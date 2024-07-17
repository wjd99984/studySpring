package com.studyspring1.discount;

import com.studyspring1.member.Grade;
import com.studyspring1.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int DiscountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * DiscountPercent / 100;
        } else {
            return 0;
        }


    }
}
