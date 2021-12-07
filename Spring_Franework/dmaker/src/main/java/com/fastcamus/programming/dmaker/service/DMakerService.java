package com.fastcamus.programming.dmaker.service;

import com.fastcamus.programming.dmaker.dto.CreateDeveloper;
import com.fastcamus.programming.dmaker.entity.Developer;
import com.fastcamus.programming.dmaker.exception.DMakerErrorCode;
import com.fastcamus.programming.dmaker.exception.DMakerException;
import com.fastcamus.programming.dmaker.repository.DeveloperRepository;
import com.fastcamus.programming.dmaker.type.DeveloperLevel;
import com.fastcamus.programming.dmaker.type.DeveloperSkillType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import java.util.Optional;

import static com.fastcamus.programming.dmaker.exception.DMakerErrorCode.DUPLICATED_MEMBER_ID;
import static com.fastcamus.programming.dmaker.exception.DMakerErrorCode.LEVEL_EXPERIENCE_YEARS_NOT_MATCHED;

@Service
@RequiredArgsConstructor // 자동으로 injection
public class DMakerService {
    //@Autowired
    //@Inject
    // 서비스 코드가 어노테이션에 종속적으로 담겨있기 때문에 서비스를 단독으로 만들기 어려움
    private final DeveloperRepository developerRepository; // 자동으로 injection
    private final EntityManager em; /// DB 추상화
    /*public DMakerService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }*/

    @Transactional // ACID 특성을 가짐 , // 공통적이고 반복적인 로직이 불필요 try catch rollback
    public CreateDeveloper.Response createDeveloper(CreateDeveloper.Request request){
        validateCreateDeveloperRequest(request);

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
        DeveloperLevel developerLevel = request.getDeveloperLevel();
        Integer experienceYears = request.getExperienceYears();
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

        //Optional<Developer> developer = developerRepository.findByMemberId(request.getMemberId());
        developerRepository.findByMemberId(request.getMemberId())
        .ifPresent((developer -> {
            throw new DMakerException(DUPLICATED_MEMBER_ID);
        }));

        /*if (developer.isPresent()) {
            throw new DMakerException(DUPLICATED_MEMBER_ID)
        }*/
    }
}
