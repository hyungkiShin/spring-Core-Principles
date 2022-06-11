package com.spring.springcore;

import com.spring.springcore.member.Grade;
import com.spring.springcore.member.Member;
import com.spring.springcore.member.MemberService;
import com.spring.springcore.order.Order;
import com.spring.springcore.order.OrderService;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        final MemberService memberService = appConfig.memberService();
        final OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        final Order itemA = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + itemA);
    }
}
