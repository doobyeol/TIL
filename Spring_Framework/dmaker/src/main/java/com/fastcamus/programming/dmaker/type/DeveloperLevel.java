package com.fastcamus.programming.dmaker.type;

import com.fastcamus.programming.dmaker.exception.DMakerException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Function;

import static com.fastcamus.programming.dmaker.constant.DMakerConstant.MAX_JUNIOR_EXPERIENCE_YEAS;
import static com.fastcamus.programming.dmaker.constant.DMakerConstant.MIN_SENIOR_EXPERIENCE_YEAS;
import static com.fastcamus.programming.dmaker.exception.DMakerErrorCode.LEVEL_EXPERIENCE_YEARS_NOT_MATCHED;

@AllArgsConstructor
@Getter
public enum DeveloperLevel {
    NEW("신입 개발자", years -> years == 0),
    JUNIOR("주니어 개발자", years -> years <= MAX_JUNIOR_EXPERIENCE_YEAS),
    JUNGNIOR("중니어 개발자", years -> years > MAX_JUNIOR_EXPERIENCE_YEAS &&
            years < MIN_SENIOR_EXPERIENCE_YEAS),
    SENIOR("시니어 개발자", years -> years >= MIN_SENIOR_EXPERIENCE_YEAS);

    private final String description;
    private final Function<Integer, Boolean> validateFunction;

    public void validateExperienceYears(Integer years){
        if (!validateFunction.apply(years))
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
    }

}
