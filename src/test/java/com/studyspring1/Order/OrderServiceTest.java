package com.studyspring1.Order;

import com.studyspring1.AppConfig;
import com.studyspring1.member.Grade;
import com.studyspring1.member.Member;
import com.studyspring1.member.MemberService;
import com.studyspring1.member.MemberServiceImpl;
import com.studyspring1.order.Order;
import com.studyspring1.order.OrderService;
import com.studyspring1.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class

OrderServiceTest {

    MemberService memberService ;
    OrderService orderService;
    @BeforeEach


    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        long memberId = 1l;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}