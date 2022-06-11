package com.spring.springcore;

import com.spring.springcore.discount.FixDiscountPolicy;
import com.spring.springcore.member.*;
import com.spring.springcore.order.Order;
import com.spring.springcore.order.OrderService;
import com.spring.springcore.order.OrderServiceImpl;

public class OrderAppV1 {

    public static void main(String[] args) {
        final MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
        final OrderService orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member); // 내가 다른배우도 섭외해서 배역도 정했고 기능도 구현

        final Order itemA = orderService.createOrder(memberId, "itemA", 20000); // 내가 다른배우도 섭외해서 배역도 정했고 기능도 구현
        System.out.println("order = " + itemA);
    }
}
