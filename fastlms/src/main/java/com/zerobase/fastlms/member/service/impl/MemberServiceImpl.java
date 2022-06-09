package com.zerobase.fastlms.member.service.impl;

import com.zerobase.fastlms.components.MailComponents;
import com.zerobase.fastlms.member.entity.Member;
import com.zerobase.fastlms.member.model.MemberInput;
import com.zerobase.fastlms.member.repository.MemberRepository;
import com.zerobase.fastlms.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MailComponents mailComponents;

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

        String uuid = UUID.randomUUID().toString();

        Member member = Member.builder()
                .userId(param.getUserId())
                .userName(param.getUserName())
                .phone(param.getPhone())
                .password(param.getPassword())
                .regDt(LocalDateTime.now())
                .emailAuthKey(uuid)
                .emailAuthYn(false)
                .build();

        memberRepository.save(member);

        String email = param.getUserId();
        String subject = "[fastlms] " + param.getUserName() + "님! 회원가입을 환영합니다.";
        String text = "<h1>fastlms 회원가입을 환영합니다!</h1>" +
                "<p>아래 링크를 클릭하여 회원 가입을 완료하세요!</p>" +
                "<a target='_blank' href='http://localhost:8080/member/email-auth?id=" + uuid + "'>이메일 인증 확인</a>";

        mailComponents.sendMail(email, subject, text);

        return true;
    }


    /**
     * uuid에 해당하는 계정을 활성화
     */
    @Override
    public boolean emailAuth(String uuid) {
        Optional<Member> optionalMember = memberRepository.findByEmailAuthKey(uuid);

        if (!optionalMember.isPresent()) {
            return false;
        }

        Member member = optionalMember.get();
        member.setEmailAuthYn(true);
        member.setEmailAuthDt(LocalDateTime.now());
        memberRepository.save(member);

        return true;
    }
}
