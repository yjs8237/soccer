package com.greatyun.soccer.member.domain;

import com.greatyun.soccer.member.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ActiveProfiles(value = "dev")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MemberTest {

    @Autowired
    MemberRepository memberRepository;

    private Member member;

    @BeforeEach
    public void before() {
        this.member = Member.builder()
                .age(36)
                .backNumber(10)
                .cellNo("01032221111")
                .imgPath("path")
                .imgUrl("url")
                .memberId("greatyun")
                .name("greatyun")
                .build();
    }

    @Test
    public void 회원_생성_테스트() {
        // given

        // when
        Member savedMember = memberRepository.save(member);
        Optional<Member> optional = memberRepository.findById(savedMember.getPkid());
        // then
        assertThat(optional.get()).isNotNull();
        assertThat(optional.get().getPkid()).isEqualTo(savedMember.getPkid());
        assertThat(optional.get().getName()).isEqualTo(savedMember.getName());
    }

    @Test
    public void 회원_삭제_테스트() {
        // given
        this.member = Member.builder()
                .age(36)
                .backNumber(10)
                .cellNo("01032221111")
                .imgPath("path")
                .imgUrl("url")
                .memberId("greatyun")
                .name("greatyun")
                .build();
        memberRepository.save(member);
        Optional<Member> optional = memberRepository.findById(member.getPkid());

        // when
        memberRepository.delete(optional.get());
        // then
        List<Member> members = memberRepository.findAll();
        assertThat(members.size()).isEqualTo(0);

    }

    @Test
    public void 회원_삭제_예외_테스트() throws Exception {
        // given
        Member savedMember = memberRepository.save(member);
        Optional<Member> optional = memberRepository.findById(savedMember.getPkid());
        // when
        Member member = optional.get();

        // then
        assertThrows(Exception.class, () -> {
            memberRepository.deleteById(2L);
        });

        //fail("예외가 발생해야 한다.");
    }



}