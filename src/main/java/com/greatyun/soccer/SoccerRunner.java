package com.greatyun.soccer;

import com.greatyun.soccer.admin.domain.Admin;
import com.greatyun.soccer.admin.repository.AdminRepository;
import com.greatyun.soccer.common.enumuration.ROLE;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@Slf4j
public class SoccerRunner implements CommandLineRunner {


    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Set<ROLE> set = new HashSet<>();
        set.add(ROLE.SUPER);
        set.add(ROLE.MANAGER);

        Admin admin = Admin.builder()
                .adminId("admin")
                .adminPwd(passwordEncoder.encode("1234"))
                .roles(set)
                .build();

        adminRepository.save(admin);

    }
}
