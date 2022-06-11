package com.spring.springcore;

import com.spring.springcore.member.Grade;
import com.spring.springcore.member.Member;
import com.spring.springcore.member.MemberService;
import com.spring.springcore.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoreApplicationTests {

    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();

    @Test
    @DisplayName("join")
    void join() {

        Member member = new Member(1L, "memberA", Grade.VIP);

        memberService.join(member);
        final Member findMember = memberService.findMember(1L);

        Assertions.assertThat(member).isEqualTo(findMember);
    }

}
