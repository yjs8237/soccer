package com.greatyun.soccer.admin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greatyun.soccer.admin.domain.Admin;
import com.greatyun.soccer.admin.dto.AdminDTO;
import com.greatyun.soccer.admin.service.AdminService;
import com.greatyun.soccer.common.enumuration.ROLE;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@WebMvcTest(controllers = AdminRestController.class ,
//        excludeFilters = {
//                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = MyWebSecurity.class)
//                , @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = PasswordEncoder.class)
//        }
//)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value = "dev")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AdminRestControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private AdminService adminService;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * @SpringBootTest 로 테스트 할 시에는 MockMvc 객체를 빈으로 주입이 안되서..
     * @Before 에서 MockMvc 객체 설정 가져와야 한다.
     */
    @BeforeEach
    public void mockMvcSetup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithMockUser(roles = "RESTAPI")
    public void 관리자_로그인_테스트() throws Exception {
        String adminId = "restapi";
        String credential = "restapi:apiuser";

        // given
        Admin admin = Admin.builder()
                .adminId(adminId)
                .adminPwd("apiuser")
                .role(ROLE.RESTAPI)
                .build();

        AdminDTO adminDTO = AdminDTO.builder()
                .adminId(adminId)
                .build();

        given(adminService.findAdminByAdminId(adminId)).willReturn(admin);

        // when and  then
        mockMvc.perform(post("/api/v1/admin/login")
            .contentType(MediaTypes.HAL_JSON_VALUE)
                .accept(MediaTypes.HAL_JSON_VALUE)
                //.header("Authorization" , "Basic " + new String(Base64.encodeBase64(credential.getBytes())))
                .content(objectMapper.writeValueAsString(adminDTO))
        )
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("result").exists())
        .andExpect(jsonPath("result").value("0"))
        .andExpect(jsonPath("description").exists())
        .andExpect(header().string(HttpHeaders.CONTENT_TYPE , MediaTypes.HAL_JSON_VALUE))
        ;

    }

}