package com.fastcamus.programming.dmaker.service;

import com.fastcamus.programming.dmaker.dto.CreateDeveloper;
import com.fastcamus.programming.dmaker.dto.DeveloperDetailDto;
import com.fastcamus.programming.dmaker.dto.DeveloperDto;
import com.fastcamus.programming.dmaker.entity.Developer;
import com.fastcamus.programming.dmaker.repository.DeveloperRepository;
import com.fastcamus.programming.dmaker.repository.RetiredDeveloperRepository;
import com.fastcamus.programming.dmaker.type.DeveloperLevel;
import com.fastcamus.programming.dmaker.type.DeveloperSkillType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

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

        given(developerRepository.findByMemberId(anyString()))
                .willReturn(Optional.of(Developer.builder()
                        .developerLevel(DeveloperLevel.SENIOR)
                        .developerSkillType(DeveloperSkillType.FRONT_END)
                        .experienceYears(12)
                        .memberId("memberId")
                        .name("name")
                        .age(32)
                        .build()));

        DeveloperDetailDto developerDetailDto = dMakerService.getDeveloperDetail("memberId");

        assertEquals(DeveloperLevel.SENIOR, developerDetailDto.getDeveloperLevel());
        assertEquals(DeveloperSkillType.FRONT_END, developerDetailDto.getDeveloperSkillType());
        assertEquals(12, developerDetailDto.getExperienceYears());
    }
}