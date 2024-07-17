package com.studyspring1.beanfind;

import com.studyspring1.AppConfig;
import com.studyspring1.member.Member;
import com.studyspring1.member.MemberService;
import com.studyspring1.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBesicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회 ")
     void finBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름없이 타입으로 조회  ")
     void finBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    //역활과 구현 의존해야하지만
    //우린 역활에 의존해야되서  좀 안좋은 코드
     void finBeanByName2() {
        MemberService memberService = ac.getBean("memberService",MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
/*
    @Test
    @DisplayName("빈 이름으로 조회 x")
    void finBeanByNameX() {
        MemberService memberService = ac.getBean("xxxx", MemberService.class);
        assertThrows(
                NoSuchBeanDefinitionException.class, () -> ac.getBean("xxxx", MemberService.class));
    }*/
}
