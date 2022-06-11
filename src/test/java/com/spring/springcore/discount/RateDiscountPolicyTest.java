package com.spring.springcore.discount;

import com.spring.springcore.member.Grade;
import com.spring.springcore.member.Member;
import com.spring.springcore.member.MemberService;
import com.spring.springcore.member.MemberServiceImpl;
import com.spring.springcore.order.Order;
import com.spring.springcore.order.OrderService;
import com.spring.springcore.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    MemberService memberService = new MemberServiceImpl();
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 면 10% 할인이 적용되어야 한다.")
    void vip_o() {
        // given when
        Member member = new Member(1L, "memberA", Grade.VIP);
        final int discount = rateDiscountPolicy.discount(member, 10000);
        System.out.println("discount = " + discount);
        // then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP 가 아니면 10% 할인이 적용되지 않아야한다.")
    void vip_x () {
        // given
        Member member = new Member(1L, "memberB", Grade.BASIC);
        final int discount = rateDiscountPolicy.discount(member, 10000);
        // when then
        Assertions.assertThat(discount).isNotEqualTo(1000);
    }
}