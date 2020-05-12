package com.greatyun.soccer.config.security;

import com.greatyun.soccer.admin.domain.Admin;
import com.greatyun.soccer.admin.service.AdminService;
import com.greatyun.soccer.config.security.SecurityUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class SecurityLoginService implements UserDetailsService {

    @Autowired
    private AdminService adminService;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
//        Admin admin = adminService.findAdminByAdminId(loginId).orElseThrow(() -> new UsernameNotFoundException(loginId));

        log.info("### loadUserByUsername findAdminByAdminId -> " + loginId);

        Optional<Admin> byAdminId = adminService.findAdminByAdminId(loginId);

        if(!byAdminId.isPresent()) {
            throw new UsernameNotFoundException(loginId);
        }
        Admin admin = byAdminId.get();
        return new SecurityUser(admin);
    }
}
