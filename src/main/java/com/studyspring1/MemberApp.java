package com.studyspring1;

import com.studyspring1.member.Grade;
import com.studyspring1.member.Member;
import com.studyspring1.member.MemberService;
import com.studyspring1.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService= appConfig.memberService();


        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class) {
        };

        MemberService memberService = ac.getBean("memberService", MemberService.class);




        Member member = new Member(1l, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1l);
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
