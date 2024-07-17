package com.studyspring1;

import com.studyspring1.member.Grade;
import com.studyspring1.member.Member;
import com.studyspring1.member.MemberService;
import com.studyspring1.member.MemberServiceImpl;
import com.studyspring1.order.Order;
import com.studyspring1.order.OrderService;
import com.studyspring1.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
       /* AppConfig appConfig =new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
*/
        ApplicationContext  ac=  new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);


/*
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();
*/

        Long memberId = 1L;
        Member member= new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 40000);

        System.out.println("order = " + order);
        System.out.println("member = " + member);

    }
}
