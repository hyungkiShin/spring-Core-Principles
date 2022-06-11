package com.spring.springcore;

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

import static org.junit.jupiter.api.Assertions.*;

class OrderAppTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

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