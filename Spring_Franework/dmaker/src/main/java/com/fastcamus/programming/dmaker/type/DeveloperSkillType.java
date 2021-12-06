package com.fastcamus.programming.dmaker.type;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DeveloperSkillType {
    BACK_END("백엔드 개발자"),
    FRONT_END("백엔드 개발자"),
    FULL_STACK("백엔드 개발자");

    private final String desription;
}
