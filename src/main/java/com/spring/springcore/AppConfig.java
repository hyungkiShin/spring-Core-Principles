package com.spring.springcore;

import com.spring.springcore.discount.RateDiscountPolicy;
import com.spring.springcore.member.MemberRepository;
import com.spring.springcore.member.MemberService;
import com.spring.springcore.order.OrderService;
import com.spring.springcore.discount.DiscountPolicy;
import com.spring.springcore.member.MemberServiceImpl;
import com.spring.springcore.member.MemoryMemberRepository;
import com.spring.springcore.order.OrderServiceImpl;

public class AppConfig {

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }


    public OrderService orderService () {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
