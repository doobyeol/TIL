package com.zerobase.fastlms.member;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MemberInput {
    private String userId;
    private String userName;
    private String password;
    private String repassword;
    private String phone;
}
