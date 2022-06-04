package com.zerobase.fastlms.member.service;

import com.zerobase.fastlms.member.entity.Member;
import com.zerobase.fastlms.member.model.MemberInput;
import com.zerobase.fastlms.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public boolean register(MemberInput param) {

        Member member = new Member();
        member.setUserId(param.getUserId());
        member.setUserName(param.getUserName());
        member.setPassword(param.getPassword());
        member.setPhone(param.getPhone());
        member.setRegDt(LocalDateTime.now());
        memberRepository.save(member);

        return false;
    }
}
