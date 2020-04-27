package com.greatyun.soccer.member.service;

import com.greatyun.soccer.member.domain.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    @Transactional
    public Member findMemberByMemberId( String memberId ) {
        return null;
    }

}
