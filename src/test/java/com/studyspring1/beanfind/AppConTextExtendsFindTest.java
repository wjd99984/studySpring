package com.studyspring1.beanfind;

import com.studyspring1.discount.DiscountPolicy;
import com.studyspring1.discount.FixDiscountPolicy;
import com.studyspring1.discount.RateDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class AppConTextExtendsFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회시 자식이 둘이상 있으면 중복오류 발생")
    void findBeanByParentTypeDuplicate() {
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("부모 타입으로 조회시 자식이 둘이상 있으면 빈 이름을 지정 ")
    void findBeanByParentTypeName() {
        DiscountPolicy ratediscountPolicy = ac.getBean("ratediscountPolicy", DiscountPolicy.class);
        assertThat(ratediscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("특정 하위 타입으로 조회 ")
    // 안좋은 방법이긴함
    void findBeanByParentType() {
        RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
        assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
    }


    @Configuration
    static class TestConfig {

        @Bean
        public DiscountPolicy ratediscountPolicy(){
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fiexDiscountPolicy(){
            return new FixDiscountPolicy();
        }




    }
}
