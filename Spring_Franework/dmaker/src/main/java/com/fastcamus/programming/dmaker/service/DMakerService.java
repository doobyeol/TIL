package com.fastcamus.programming.dmaker.service;

import com.fastcamus.programming.dmaker.code.StatusCode;
import com.fastcamus.programming.dmaker.dto.CreateDeveloper;
import com.fastcamus.programming.dmaker.dto.DeveloperDetailDto;
import com.fastcamus.programming.dmaker.dto.DeveloperDto;
import com.fastcamus.programming.dmaker.dto.EditDeveloper;
import com.fastcamus.programming.dmaker.entity.Developer;
import com.fastcamus.programming.dmaker.entity.RetiredDeveloper;
import com.fastcamus.programming.dmaker.exception.DMakerErrorCode;
import com.fastcamus.programming.dmaker.exception.DMakerException;
import com.fastcamus.programming.dmaker.repository.DeveloperRepository;
import com.fastcamus.programming.dmaker.repository.RetiredDeveloperRepository;
import com.fastcamus.programming.dmaker.type.DeveloperLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.fastcamus.programming.dmaker.exception.DMakerErrorCode.*;

@Service
@RequiredArgsConstructor // 자동으로 injection
public class DMakerService {
    //@Autowired
    //@Inject
    // 서비스 코드가 어노테이션에 종속적으로 담겨있기 때문에 서비스를 단독으로 만들기 어려움
    private final DeveloperRepository developerRepository; // 자동으로 injection
    private final RetiredDeveloperRepository retiredDeveloperRepository; // 자동으로 injection
    private final EntityManager em; /// DB 추상화
    /*public DMakerService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }*/

    @Transactional // ACID 특성을 가짐 , // 공통적이고 반복적인 로직이 불필요 try catch rollback
    // cntl + shift + T 테스트
    public CreateDeveloper.Response createDeveloper(CreateDeveloper.Request request){
        validateCreateDeveloperRequest(request);
        /*boolean validationResult = validateCreateDeveloperRequest2(request);
        if (!validationResult){
            return CreateDeveloper.Response(DUPLICATED_MEMBER_ID);
        }*/
       // EntityTransaction transaction = em.getTransaction();
        //try {
            //transaction.begin();

            // business logic start

            Developer developer = Developer.builder()
                    .developerLevel(request.getDeveloperLevel())
                    .developerSkillType(request.getDeveloperSkillType())
                    .experienceYears(request.getExperienceYears())
                    .name(request.getName())
                    .age(request.getAge())
                    .memberId(request.getMemberId())
                    .statusCode(StatusCode.EMPLOYED)
                    .build();
            
            // a-> b 1만원 송금 로직
            // a 계좌에서 1만원 줄임
            developerRepository.save(developer); // 영속화, DB저장
            // b계좌에서 1만원 늘림
            //developerRepository.delete(developer1);

            // business logic end

            //transaction.commit();
        //}catch (Exception e){
            //transaction.rollback();
            //throw e;
        //}

            return CreateDeveloper.Response.fromEntity(developer);

    }

    private void validateCreateDeveloperRequest(CreateDeveloper.Request request) {
        // business validataion 비즈니스 검증
        validateDeveloperLevel(
                request.getDeveloperLevel(),
                request.getExperienceYears()
        );

        //Optional<Developer> developer = developerRepository.findByMemberId(request.getMemberId());
        developerRepository.findByMemberId(request.getMemberId())
        .ifPresent((developer -> {
            throw new DMakerException(DUPLICATED_MEMBER_ID);
        }));

        /*if (developer.isPresent()) {
            throw new DMakerException(DUPLICATED_MEMBER_ID)
        }*/

        //throw new ArrayIndexOutOfBoundsException();
    }

    private boolean validateCreateDeveloperRequest2(CreateDeveloper.Request request) {
        validateDeveloperLevel(
                request.getDeveloperLevel(),
                request.getExperienceYears()
        );

        try {
            developerRepository.findByMemberId(request.getMemberId())
                    .ifPresent((developer -> {
                        throw new DMakerException(DUPLICATED_MEMBER_ID);
                    }));

        }catch (DMakerException ex){
            return false;
        }

        if(request.getDeveloperLevel() != DeveloperLevel.SENIOR){
            return false;
        }
        return true;
    }

    public List<DeveloperDto> getAllEmployedDevelopers() {
        return developerRepository.findDevelopersByStatusCodeEquals(StatusCode.EMPLOYED)
                .stream().map(DeveloperDto::fromEntity)
                .collect(Collectors.toList());
    }

    public DeveloperDetailDto getDeveloperDetail(String memberId) {
        return developerRepository.findByMemberId(memberId)
                .map(DeveloperDetailDto::fromEntity)
                .orElseThrow(() -> new DMakerException(NO_DEVELOPER));
    }

    // 실제 DB 반영되도록 @Transactional 키워드를 통해서
    @Transactional // 이 메소드가 들어가기전에 트랜잭션을 시작
                    // developer 엔티티에 값을 바꿔준 다음
                    // 전체 체킹을 해서 변경된 사항을 커밋이 되도록
    public DeveloperDetailDto editDeveloper(String memberId, EditDeveloper.Request request) {
        validateEditDeveloperRequest(request, memberId);

        Developer developer = developerRepository.findByMemberId(memberId).orElseThrow(
                () -> new DMakerException(NO_DEVELOPER)
        );

        developer.setDeveloperLevel(request.getDeveloperLevel());
        developer.setDeveloperSkillType(request.getDeveloperSkillType());
        developer.setExperienceYears(request.getExperienceYears());

        return DeveloperDetailDto.fromEntity(developer);
    }

    private void validateEditDeveloperRequest(EditDeveloper.Request request, String memberId) {
        validateDeveloperLevel(
                request.getDeveloperLevel(),
                request.getExperienceYears()
        );

        developerRepository.findByMemberId(memberId).orElseThrow(
                () -> new DMakerException(NO_DEVELOPER)
        );

    }

    private void validateDeveloperLevel( DeveloperLevel developerLevel, Integer experienceYears) {
        if(developerLevel == DeveloperLevel.SENIOR
                && experienceYears < 10) {
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }

        if(developerLevel == DeveloperLevel.JUNIOR
                && ( experienceYears < 4 ||
                experienceYears > 10)){
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }

        if(developerLevel == DeveloperLevel.JUNIOR && experienceYears > 4) {
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }
    }


    @Transactional // DB조작
    public DeveloperDetailDto deleteDeveloper(String memberId) {
        // 1. EMPLOYED -> RETIRED
        Developer developer = developerRepository.findByMemberId(memberId)
                .orElseThrow(() -> new DMakerException(NO_DEVELOPER));
        developer.setStatusCode(StatusCode.RETIRED);
        //developerRepository.save(developer);
       // if(developer != null) throw new DMakerException((NO_DEVELOPER)); // rollback

        // 2. save into RetiredDeveloper..
        RetiredDeveloper retiredDeveloper = RetiredDeveloper.builder()
                .memberId(memberId)
                .name(developer.getName())
                .build();
        retiredDeveloperRepository.save(retiredDeveloper);

        return DeveloperDetailDto.fromEntity(developer);
    }
}
