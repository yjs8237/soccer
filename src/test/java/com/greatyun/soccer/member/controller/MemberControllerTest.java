package com.greatyun.soccer.member.controller;


import com.greatyun.soccer.config.MyWebSecurity;
import com.greatyun.soccer.member.domain.Member;
import com.greatyun.soccer.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.contains;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


/**
 * @WebMvcTest 에서는 Mvc 관련된 Bean 만 스캔하게된다.. 그래서 스프링시큐리티 관련 Bean 은 올라오지 않기 때문에
 * 시큐리티 설정이 되어 있으면 테스트가 깨지게 된다.
 *
 * 테스트 깨짐 방지를 위해 아래 설정을 해준다.
 */
@WebMvcTest(controllers = MemberController.class ,
    excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = MyWebSecurity.class)
    }
)
class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @WithMockUser("USER")
    @Test
    public void Member_Page_Controller_테스트() throws Exception {
        String memberId = "test";
        // given
        given(memberService.findMemberByMemberId(memberId)).willReturn(new Member());
        // when
        ResultActions result = mockMvc.perform(get("/member/main"));
        // then
        result.andExpect(status().isOk());
        result.andExpect(view().name("member/main"));

    }
}