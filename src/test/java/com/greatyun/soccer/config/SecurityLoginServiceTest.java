package com.greatyun.soccer.config;

import com.greatyun.soccer.admin.domain.Admin;
import com.greatyun.soccer.admin.repository.AdminRepository;
import com.greatyun.soccer.common.enumuration.ROLE;
import com.greatyun.soccer.config.security.SecurityLoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ActiveProfiles;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles(value = "dev")
class SecurityLoginServiceTest {

    @Autowired
    private SecurityLoginService securityLoginService;

    @Autowired
    private AdminRepository adminRepository;

    @Test
    public void findByUsername() {
        // given
        Set<ROLE> set = new HashSet<>();
        set.add(ROLE.SUPER);
        set.add(ROLE.MANAGER);

        String adminId = "test";
        Admin admin = Admin.builder()
                .adminId(adminId)
                .adminPwd("1234")
                .roles(set)
                .build();

        // when
        adminRepository.save(admin);

        UserDetailsService userDetailsService = securityLoginService;
        UserDetails userDetails = userDetailsService.loadUserByUsername(adminId);

        System.out.println(userDetails.getAuthorities().size() + " " + admin.getRoles().size());
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        Iterator<? extends GrantedAuthority> iterator = authorities.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " , ");
        }
        assertThat(userDetails.getUsername()).isEqualTo(admin.getAdminId());
    }

    @Test
    public void 시큐리티_User_Not_found() {
        assertThrows(UsernameNotFoundException.class, () -> {
            securityLoginService.loadUserByUsername("111");
        });
    }

}