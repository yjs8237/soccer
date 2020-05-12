package com.greatyun.soccer.config.security;

import com.greatyun.soccer.admin.domain.Admin;
import com.greatyun.soccer.admin.repository.AdminRepository;
import com.greatyun.soccer.admin.service.AdminService;
import com.greatyun.soccer.common.enumuration.ROLE;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AuthServerConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private WebApplicationContext context;


    @Test
    public void oauth_테스트() throws Exception {

        // given
        String clientId = "soccer_user";
//        String clientSecret = passwordEncoder.encode("P@ssw0rd");
        String clientSecret = "1234";
        String username = "admin";
        String password = "1234";

        Set<ROLE> set = new HashSet<>();
        set.add(ROLE.SUPER);
        set.add(ROLE.MANAGER);

        Admin admin = Admin.builder()
                .adminId(username)
                .adminPwd(password)
                .roles(set)
                .build();
        adminRepository.save(admin);

        // when and  then
        mockMvc.perform(post("/oauth/token")
                .with(httpBasic(clientId , clientSecret))
                .param("username" , username)
                .param("password" , password)
                .param("grant_type" , "password")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("access_token").exists())
        ;

    }




}