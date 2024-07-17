package com.studyspring1.Member;

import com.studyspring1.AppConfig;
import com.studyspring1.member.Grade;
import com.studyspring1.member.Member;
import com.studyspring1.member.MemberService;
import com.studyspring1.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

        @Test
        public void join() {
            //given
            Member member = new Member(1L, "memberA", Grade.VIP);

            //when
            memberService.join(member);
            Member findMember=memberService.findMember(1L);

            //then
            Assertions.assertThat(member).isEqualTo(findMember);
        }







}