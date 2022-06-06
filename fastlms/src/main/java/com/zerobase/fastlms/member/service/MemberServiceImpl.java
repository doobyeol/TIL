package com.zerobase.fastlms.member.service;

import com.zerobase.fastlms.member.entity.Member;
import com.zerobase.fastlms.member.model.MemberInput;
import com.zerobase.fastlms.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    /**
     * 회원가입
     */
    @Override
    public boolean register(MemberInput param) {

        Optional<Member> optionalMember = memberRepository.findById(param.getUserId());
        if (optionalMember.isPresent()) {
            // 현재 userId에 해당하는 데이터가 이미 존재
            return false;
        }

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
