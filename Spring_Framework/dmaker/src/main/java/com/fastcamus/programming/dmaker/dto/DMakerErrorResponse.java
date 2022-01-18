package com.fastcamus.programming.dmaker.dto;

import com.fastcamus.programming.dmaker.exception.DMakerErrorCode;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DMakerErrorResponse {
    private DMakerErrorCode  errorCode;
    private String errorMessage;

}
