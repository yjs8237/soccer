package com.greatyun.soccer.admin.domain;

import com.greatyun.soccer.admin.repository.AdminRepository;
import com.greatyun.soccer.common.enumuration.ROLE;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
@ActiveProfiles(value = "dev")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AdminTest {

    @Autowired
    private AdminRepository adminRepository;

    @Test
    public void 관리자_권한_테스트() {

        Set<ROLE> set = new HashSet<>();
        set.add(ROLE.SUPER);
        set.add(ROLE.MANAGER);

        Admin admin = Admin.builder()
                .adminId("test")
                .adminPwd("1234")
                .roles(set)
                .build();

        // when
        adminRepository.save(admin);
        
        // then
        Optional<Admin> optionalAdmin = adminRepository.findByAdminId("test");

        assertThat(optionalAdmin.get().getAdminPwd()).isNotNull();

    }



}