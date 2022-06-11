package com.spring.springcore.order;

import com.spring.springcore.AppConfig;
import com.spring.springcore.member.Grade;
import com.spring.springcore.member.Member;
import com.spring.springcore.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderAppTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void BeforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    @DisplayName("OrderServiceTest")
    void OrderServiceTest() {
        // given
        Long memberId = 1L;
        // when
        Member member = new Member(memberId, "memberA", Grade.VIP);
        // then
        memberService.join(member);
        final Order order = orderService.createOrder(memberId, member.getName(), 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}