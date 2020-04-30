package com.greatyun.soccer.member.repository;

import com.greatyun.soccer.member.condition.MemberSearchCondition;
import com.greatyun.soccer.member.domain.Member;
import com.greatyun.soccer.member.dto.MemberDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ActiveProfiles(value = "dev")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MemberRepositoryImplTest {

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    public void 사전_멤버_생성() {
        Member member = Member.builder()
                .name("jisang")
                .memberId("greatyun")
                .imgUrl("1")
                .imgPath("2")
                .cellNo("01012341234")
                .backNumber(10)
                .age(36)
                .build();

        memberRepository.save(member);
        member = Member.builder()
                .name("yun")
                .memberId("greatyun")
                .imgUrl("1")
                .imgPath("2")
                .cellNo("01012341234")
                .backNumber(10)
                .age(36)
                .build();
        memberRepository.save(member);

    }

    @Test
    public void 멤버_조회_테스트() {
        MemberSearchCondition condition = MemberSearchCondition.builder().name("jisang").build();
        List<MemberDTO> memberDTOS = memberRepository.testQueryDsl(condition);
        assertThat(memberDTOS.size()).isEqualTo(1);
        assertThat(memberDTOS.get(0).getName()).isEqualTo("jisang");
    }

    @Test
    public void 멤버_조회_Condition_null_테스트() throws Exception {
        /* where 조건이 걸리지 않아야 한다 */
        // given
        MemberSearchCondition condition = MemberSearchCondition.builder().build();

        // when
        List<MemberDTO> memberDTOS = memberRepository.testQueryDsl(condition);

        // then
        assertThat(memberDTOS.size()).isEqualTo(2);
        assertThat(memberDTOS.get(0).getName()).isEqualTo("jisang");
    }


    @Test
    public void 람다_테스트() {
        List<MemberDTO> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MemberDTO memberDTO = MemberDTO.builder()
                    .name("jisang")
                    .build();
            list.add(memberDTO);
        }
        List<MemberDTO> result = list.stream().map(MemberDTO::nameChange).collect(Collectors.toList());
        for (MemberDTO memberDTO : result) {
            System.out.println(memberDTO.getName());
        }
    }

}