package com.studyspring1.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}
