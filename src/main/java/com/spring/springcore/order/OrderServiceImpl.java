package com.spring.springcore.order;

import com.spring.springcore.discount.DiscountPolicy;
import com.spring.springcore.member.Member;
import com.spring.springcore.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository; // = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy; //  = new FixDiscountPolicy();

    public OrderServiceImpl(final MemberRepository memberRepository, final DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(final Long memberId, final String itemName, final int itemPrice) {
        Member member = memberRepository.findById(memberId);
        final int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
