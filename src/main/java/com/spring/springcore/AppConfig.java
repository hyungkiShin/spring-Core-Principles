package com.spring.springcore;

import com.spring.springcore.member.MemberRepository;
import com.spring.springcore.member.MemberService;
import com.spring.springcore.order.OrderService;
import com.spring.springcore.discount.DiscountPolicy;
import com.spring.springcore.member.MemberServiceImpl;
import com.spring.springcore.member.MemoryMemberRepository;
import com.spring.springcore.order.OrderServiceImpl;
import com.spring.springcore.discount.FixDiscountPolicy;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService () {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
