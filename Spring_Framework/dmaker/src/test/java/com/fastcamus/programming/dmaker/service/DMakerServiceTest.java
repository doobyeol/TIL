package com.fastcamus.programming.dmaker.service;

import com.fastcamus.programming.dmaker.dto.CreateDeveloper;
import com.fastcamus.programming.dmaker.dto.DeveloperDetailDto;
import com.fastcamus.programming.dmaker.entity.Developer;
import com.fastcamus.programming.dmaker.exception.DMakerErrorCode;
import com.fastcamus.programming.dmaker.exception.DMakerException;
import com.fastcamus.programming.dmaker.repository.DeveloperRepository;
import com.fastcamus.programming.dmaker.repository.RetiredDeveloperRepository;
import com.fastcamus.programming.dmaker.type.DeveloperLevel;
import com.fastcamus.programming.dmaker.type.DeveloperSkillType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.fastcamus.programming.dmaker.constant.DMakerConstant.MAX_JUNIOR_EXPERIENCE_YEAS;
import static com.fastcamus.programming.dmaker.constant.DMakerConstant.MIN_SENIOR_EXPERIENCE_YEAS;
import static com.fastcamus.programming.dmaker.type.DeveloperLevel.*;
import static com.fastcamus.programming.dmaker.type.DeveloperSkillType.FRONT_END;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

//@SpringBootTest // DMakerServiceTest안에서 모든 bean을 띄우게 된다.
@ExtendWith(MockitoExtension.class) // Mocking 외부기능을 활용한 테스트
class DMakerServiceTest {
    @Mock
    private DeveloperRepository developerRepository;

    @Mock
    private RetiredDeveloperRepository retiredDeveloperRepository;

    //@Autowired // DMakerService injection
    @InjectMocks // 가짜 목업
    private DMakerService dMakerService;

    private final Developer defaultDeveloper =  Developer.builder()
            .developerLevel(SENIOR)
            .developerSkillType(FRONT_END)
            .experienceYears(12)
            .memberId("memberId")
            .name("name")
            .age(32)
            .build();

    private CreateDeveloper.Request getCreateRequest(
            DeveloperLevel developerLevel,
            DeveloperSkillType developerSkillType,
            Integer experienceYears
    ){
        return CreateDeveloper.Request.builder()
                .developerLevel(developerLevel)
                .developerSkillType(developerSkillType)
                .experienceYears(experienceYears)
                .memberId("memberId")
                .name("name")
                .age(32)
                .build();
    }

    @Test
    public void testSomething(){
        /*dMakerService.createDeveloper(CreateDeveloper.Request.builder()
                .developerLevel(DeveloperLevel.SENIOR)
                .developerSkillType(DeveloperSkillType.FRONT_END)
                .experienceYears(12)
                .memberId("memberId")
                .name("name")
                .age(32)
                .build());
        List<DeveloperDto> allEmployedDevelopers = dMakerService.getAllEmployedDevelopers();
        System.out.println("============================");
        System.out.println(allEmployedDevelopers);
        System.out.println("============================");*/


        // given
        given(developerRepository.findByMemberId(anyString()))
                .willReturn(Optional.of(defaultDeveloper));

        // when
        DeveloperDetailDto developerDetailDto = dMakerService.getDeveloperDetail("memberId");

        // then
        assertEquals(SENIOR, developerDetailDto.getDeveloperLevel());
        assertEquals(FRONT_END, developerDetailDto.getDeveloperSkillType());
        assertEquals(12, developerDetailDto.getExperienceYears());
    }

    @Test
    void createDeveloperTest_success(){
        // tdd
        // given
        given(developerRepository.findByMemberId(anyString()))
                .willReturn(Optional.empty());

        given(developerRepository.save(any()))
                .willReturn(defaultDeveloper);

        ArgumentCaptor<Developer> captor =
                ArgumentCaptor.forClass(Developer.class);

        // when
        CreateDeveloper.Response developer = dMakerService.createDeveloper(getCreateRequest(SENIOR, FRONT_END, 12));

        // then
        verify(developerRepository, times(1))
                .save(captor.capture());

        Developer saveDeveloper = captor.getValue();

        assertEquals(SENIOR, saveDeveloper.getDeveloperLevel());
        assertEquals(FRONT_END, saveDeveloper.getDeveloperSkillType());
        assertEquals(12, saveDeveloper.getExperienceYears());

    }

    @Test
    void createDeveloperTest_fail_with_unmatched_level(){
        // tdd
        // given
        // when
        // then

        DMakerException dMakerException = assertThrows(DMakerException.class,
                () -> dMakerService.createDeveloper(
                        getCreateRequest(JUNIOR, FRONT_END, MAX_JUNIOR_EXPERIENCE_YEAS + 1)
                )
        );
        assertEquals(DMakerErrorCode.LEVEL_EXPERIENCE_YEARS_NOT_MATCHED,
                dMakerException.getDMakerErrorCode()
        );

        dMakerException = assertThrows(DMakerException.class,
                () -> dMakerService.createDeveloper(
                        getCreateRequest(JUNGNIOR, FRONT_END, MIN_SENIOR_EXPERIENCE_YEAS + 1)
                )
        );
        assertEquals(DMakerErrorCode.LEVEL_EXPERIENCE_YEARS_NOT_MATCHED,
                dMakerException.getDMakerErrorCode()
        );

        dMakerException = assertThrows(DMakerException.class,
                () -> dMakerService.createDeveloper(
                        getCreateRequest(SENIOR, FRONT_END, MIN_SENIOR_EXPERIENCE_YEAS - 1)
                )
        );
        assertEquals(DMakerErrorCode.LEVEL_EXPERIENCE_YEARS_NOT_MATCHED,
                dMakerException.getDMakerErrorCode()
        );
    }

    @Test
    void createDeveloperTest_failed_with_duplicated(){
        // tdd
        // given
        given(developerRepository.findByMemberId(anyString()))
                .willReturn(Optional.of(defaultDeveloper));
        ArgumentCaptor<Developer> captor =
                ArgumentCaptor.forClass(Developer.class);

        // when
        //CreateDeveloper.Response developer = dMakerService.createDeveloper(defaultCreateDeveloper);


        // then
        /*verify(developerRepository, times(1))
                .save(captor.capture());

        Developer saveDeveloper = captor.getValue();

        assertEquals(SENIOR, saveDeveloper.getDeveloperLevel());
        assertEquals(FRONT_END, saveDeveloper.getDeveloperSkillType());
        assertEquals(12, saveDeveloper.getExperienceYears());*/
        DMakerException dMakerException = assertThrows(DMakerException.class,
                () -> dMakerService.createDeveloper(getCreateRequest(SENIOR, FRONT_END, MIN_SENIOR_EXPERIENCE_YEAS))
        );

        assertEquals(DMakerErrorCode.DUPLICATED_MEMBER_ID, dMakerException.getDMakerErrorCode());
    }


}