package com.spring.springcore;

import com.spring.springcore.member.Grade;
import com.spring.springcore.member.Member;
import com.spring.springcore.member.MemberService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CoreApplication2 {

    public static void main(String[] args) {
        // AppConfig 에 있는 환경설정을 Spring Container 에 다 집어넣어서 관리함.
        final AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig2.class);
        final MemberService memberService = annotationConfigApplicationContext.getBean("memberService", MemberService.class);
        final Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        final Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }

}
