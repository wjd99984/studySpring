package com.studyspring1.singletonTest;

import com.studyspring1.AppConfig;

import com.studyspring1.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {


    @Test
    @DisplayName("스프링없는 순수 Di 컨터이너")
        void test () {
            AppConfig a = new AppConfig();

            MemberService memberService = a.memberService();

            MemberService memberService2 = a.memberService();

            System.out.println("memberService = " + memberService);
            System.out.println("memberService2 = " + memberService2);
            //Then
            assertThat(memberService).isNotSameAs(memberService2);
        }


    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService instance = SingletonService.getInstance();
        SingletonService instance1 = SingletonService.getInstance();

        System.out.println("instance = " + instance);
        System.out.println("instance1 = " + instance1);

        assertThat(instance).isSameAs(instance1);
        //same ==
        //equal 자바의 이퀄즈랑 같음
    }

}
