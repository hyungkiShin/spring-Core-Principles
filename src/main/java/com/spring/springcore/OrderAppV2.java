package com.spring.springcore;

import com.spring.springcore.member.Grade;
import com.spring.springcore.member.Member;
import com.spring.springcore.member.MemberService;
import com.spring.springcore.order.Order;
import com.spring.springcore.order.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderAppV2 {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig(); // 기획자
//        final MemberService memberService = appConfig.memberService(); // 배우 지정
//        final OrderService orderService = appConfig.orderService(); // 배우 지정

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig2.class);
        final MemberService memberService = ac.getBean("memberService", MemberService.class);
        final OrderService orderService = ac.getBean("orderService", OrderService.class);
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        memberService.join(member); // 배우

        final Order itemA =  orderService.createOrder(memberId, "itemA", 20000); // 배우
        System.out.println("order = " + itemA);
    }
}
