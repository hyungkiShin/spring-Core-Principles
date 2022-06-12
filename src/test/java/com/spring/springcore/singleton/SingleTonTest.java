package com.spring.springcore.singleton;

import com.spring.springcore.AppConfig2;
import com.spring.springcore.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingleTonTest {


    @Test
    @DisplayName("singleton Test")
    void singletonTest() {
        // given
        AppConfig2 appConfig = new AppConfig2();
        final MemberService memberService1 = appConfig.memberService();
        final MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
        // when then
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("singleton 패턴을 사용한 객체 사용")
    void singleton_패턴을_사용한_객체_사용() {
        // given
        final SingleTonService instance1 = SingleTonService.getInstance();
        final SingleTonService instance2 = SingleTonService.getInstance();
        // when
        // then
        System.out.println("instance2 = " + instance1);
        System.out.println("instance2 = " + instance2);

        Assertions.assertThat(instance1).isSameAs(instance2);

        instance1.logic();
    }

    @Test
    @DisplayName("singleton 패턴을 사용한 객체 사용")
    void spring_singleton_패턴이_이미_먹어있다() {
        // given
        final AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig2.class);
        final MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        final MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        // when then
        System.out.println("instance2 = " + memberService1);
        System.out.println("instance2 = " + memberService2);

        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}
