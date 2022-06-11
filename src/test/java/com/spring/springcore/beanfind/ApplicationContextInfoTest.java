package com.spring.springcore.beanfind;

import com.spring.springcore.AppConfig2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig2.class);

    @Test
    @DisplayName("모든빈 호출하기")
    void 모든빈_호출하기() {
        // given
        final String[] names = ac.getBeanDefinitionNames();
        System.out.println("======================================");
        // when then
        for (String name : names) {
            final Object bean = ac.getBean(name);
            System.out.println("name = " + name + ", " + "   bean = " + bean);
        }
    }

    @Test
    @DisplayName("에플리케이션 빈 호출하기")
    void 에플리케이션_빈_호출하기() {
        // given
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        System.out.println(" ================================================== ");

        // when then
        for (String beanDefinitionName : beanDefinitionNames) {
            final BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            // 내가 애플리케이션에서 등록한 빈 을 확인하고 싶을때.
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                final Object bean = ac.getBean(beanDefinitionName);
                System.out.println("bean = " + bean + ", " + "   beanDefinition = " + beanDefinition);
            }
        }
    }
}
