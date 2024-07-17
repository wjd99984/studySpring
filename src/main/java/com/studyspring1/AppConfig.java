package com.studyspring1;

import com.studyspring1.discount.DiscountPolicy;
import com.studyspring1.discount.FixDiscountPolicy;
import com.studyspring1.discount.RateDiscountPolicy;
import com.studyspring1.member.MemberRepository;
import com.studyspring1.member.MemberService;
import com.studyspring1.member.MemberServiceImpl;
import com.studyspring1.member.MemoryMemberRepository;
import com.studyspring1.order.OrderService;
import com.studyspring1.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean  //spring 컨테이너 등록
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }


}
