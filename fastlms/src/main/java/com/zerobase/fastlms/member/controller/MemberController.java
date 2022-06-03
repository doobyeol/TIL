package com.zerobase.fastlms.member.controller;

import com.zerobase.fastlms.member.entity.Member;
import com.zerobase.fastlms.member.model.MemberInput;
import com.zerobase.fastlms.member.repository.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@Controller
public class MemberController {

    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping(value = "/member/register")
    public String register() {
        return "member/register";
    }

    @PostMapping(value = "/member/register")
    public String registerSubmit(HttpServletRequest request, HttpServletResponse response, MemberInput param) {

        System.out.println("param : " + param.toString());

        Member member = new Member();
        member.setUserId(param.getUserId());
        member.setPassword(param.getPassword());
        member.setPhone(param.getPhone());
        member.setRegDt(LocalDateTime.now());
        memberRepository.save(member);


        return "member/register_complete";
    }
}
