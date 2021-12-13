package com.fastcamus.programming.dmaker.dto;

import com.fastcamus.programming.dmaker.entity.Developer;
import com.fastcamus.programming.dmaker.type.DeveloperLevel;
import com.fastcamus.programming.dmaker.type.DeveloperSkillType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DeveloperDto {
    private DeveloperLevel developerLevel;
    private DeveloperSkillType developerSkillType;
    private String memberId;

    public static DeveloperDto fromEntity(Developer developer){
        return DeveloperDto.builder()
                .developerLevel(developer.getDeveloperLevel())
                .developerSkillType((developer.getDeveloperSkillType()))
                .memberId(developer.getMemberId())
                .build();
    }
}
