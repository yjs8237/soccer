package com.greatyun.soccer.member.repository;

import com.greatyun.soccer.member.condition.MemberSearchCondition;
import com.greatyun.soccer.member.domain.Member;
import com.greatyun.soccer.member.dto.MemberDTO;

import java.util.List;

public interface MemberRepositoryCustom {
    public List<Member> testCustom(MemberSearchCondition condition);

    public List<MemberDTO> testQueryDsl(MemberSearchCondition condition);
}
