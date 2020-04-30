package com.greatyun.soccer.member.repository.impl;

import com.greatyun.soccer.member.condition.MemberSearchCondition;
import com.greatyun.soccer.member.domain.Member;
import com.greatyun.soccer.member.domain.QMember;
import com.greatyun.soccer.member.dto.MemberDTO;
import com.greatyun.soccer.member.dto.QMemberDTO;
import com.greatyun.soccer.member.repository.MemberRepositoryCustom;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.greatyun.soccer.member.domain.QMember.member;
import static org.springframework.util.StringUtils.isEmpty;

public class MemberRepositoryImpl implements MemberRepositoryCustom {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Member> testCustom(MemberSearchCondition condition) {
        return jpaQueryFactory
                .select(member)
                .from(member)
                .where(
                        usernameEq(condition.getName())
                        ,memberIdEq(condition.getMemberId())
                )
                .fetch();
    }

    @Override
    public List<MemberDTO> testQueryDsl(MemberSearchCondition condition) {
        return jpaQueryFactory
                .select(new QMemberDTO(
                        member.memberId
                        ,member.name
                        ,member.cellNo
                        ,member.age
                        ,member.backNumber
                        ,member.imgUrl
                        ,member.imgPath
                ))
                .from(member)
                .where(usernameEq(condition.getName()))
                .fetch();
    }

    private BooleanExpression usernameEq(String name) {
        return isEmpty(name) ? null : member.name.eq(name);
    }

    private BooleanExpression memberIdEq(String memberId) {
        return isEmpty(memberId) ? null : member.memberId.eq(memberId);
    }


}
