package com.fastcamus.programming.dmaker.dto;

import com.fastcamus.programming.dmaker.entity.Developer;
import com.fastcamus.programming.dmaker.type.DeveloperLevel;
import com.fastcamus.programming.dmaker.type.DeveloperSkillType;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateDeveloper {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    public static class Request{ // 데이터 검증 DTO
        @NotNull
        private DeveloperLevel developerLevel;
        @NotNull
        private DeveloperSkillType developerSkillType;
        @NotNull
        @Min(0)
        @Max(20)
        private Integer experienceYears;

        @NotNull
        @Size(min = 3, max = 50, message = "memberId size must 3 ~ 50")
        private String memberId;
        @NotNull
        @Size(min = 3, max = 20, message = "name size must 3 ~ 20")
        private String name;

        @Min(18)
        private Integer age;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response{
        private DeveloperLevel developerLevel;
        private DeveloperSkillType developerSkillType;
        private Integer experienceYears;
        private String memberId;

        /*private ErrorCode errorCode;
        private String errorMessage;*/

        public static Response fromEntity(@NonNull Developer developer){
            return Response.builder()
                .developerSkillType(developer.getDeveloperSkillType())
                .developerLevel(developer.getDeveloperLevel())
                .memberId(developer.getMemberId())
                .experienceYears(developer.getExperienceYears())
                .build();
        }
    }
}
