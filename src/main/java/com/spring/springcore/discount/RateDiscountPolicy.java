package com.spring.springcore.discount;

import com.spring.springcore.member.Grade;
import com.spring.springcore.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int disCountPercent = 10;
    @Override
    public int discount(final Member member, final int price) {

        if(member.getGrade() == Grade.VIP) {
            return price * disCountPercent / 100;
        }
        return 0;
    }
}
