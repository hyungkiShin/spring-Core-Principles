package com.spring.springcore;

import com.spring.springcore.member.Grade;
import com.spring.springcore.member.Member;
import com.spring.springcore.member.MemberService;
import com.spring.springcore.member.MemberServiceImpl;

public class CoreApplication {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        // V1 MemberService memberService = new MemberServiceImpl(memberRepository);
        final MemberService memberService = appConfig.memberService();
        final Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        final Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }

}
