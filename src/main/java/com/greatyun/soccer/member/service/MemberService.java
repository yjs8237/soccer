package com.greatyun.soccer.member.service;

import com.greatyun.soccer.member.condition.MemberSearchCondition;
import com.greatyun.soccer.member.domain.Member;
import com.greatyun.soccer.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    public Member findMemberByMemberId(String memberId ) {
        return null;
    }

    @Transactional
    public List<Member> testCustom(String memberId ) {
        MemberSearchCondition condition = MemberSearchCondition.builder()
                .memberId(memberId)
                .build();
        return memberRepository.testCustom(condition);
    }

}
