package com.fastcamus.programming.dmaker.dto;

import com.fastcamus.programming.dmaker.code.StatusCode;
import com.fastcamus.programming.dmaker.entity.Developer;
import com.fastcamus.programming.dmaker.type.DeveloperLevel;
import com.fastcamus.programming.dmaker.type.DeveloperSkillType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeveloperDetailDto {
    private DeveloperLevel developerLevel;
    private DeveloperSkillType developerSkillType;
    private Integer experienceYears;
    private String memberId;
    private String name;
    private Integer age;
    private StatusCode statusCode;

    public static DeveloperDetailDto fromEntity(Developer developer){
        return DeveloperDetailDto.builder()
                .developerLevel(developer.getDeveloperLevel())
                .developerSkillType((developer.getDeveloperSkillType()))
                .experienceYears(developer.getExperienceYears())
                .memberId(developer.getMemberId())
                .name(developer.getName())
                .age(developer.getAge())
                .statusCode(developer.getStatusCode())
                .build();
    }
}
