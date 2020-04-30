package com.greatyun.soccer.member.repository;

import com.greatyun.soccer.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member , Long> , MemberRepositoryCustom {

}
