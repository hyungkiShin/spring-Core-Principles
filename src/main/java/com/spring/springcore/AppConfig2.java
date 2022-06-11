package com.spring.springcore;

import com.spring.springcore.discount.DiscountPolicy;
import com.spring.springcore.discount.RateDiscountPolicy;
import com.spring.springcore.member.MemberRepository;
import com.spring.springcore.member.MemberService;
import com.spring.springcore.member.MemberServiceImpl;
import com.spring.springcore.member.MemoryMemberRepository;
import com.spring.springcore.order.OrderService;
import com.spring.springcore.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig2 {

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService () {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
