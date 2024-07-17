package com.studyspring1.discount;

import com.studyspring1.member.Member;

public interface DiscountPolicy {

    int discount(Member member,int price);
}
