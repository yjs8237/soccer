package com.greatyun.soccer.config;

import com.greatyun.soccer.admin.domain.Admin;
import com.greatyun.soccer.admin.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SecurityLoginService implements UserDetailsService {

    @Autowired
    private AdminService adminService;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        User user = null;
        try {
            Admin admin = adminService.findAdminByAdminId(loginId);
            if(admin == null) {
                throw new UsernameNotFoundException(loginId);
            } else {
//            log.info("admin pwd : " + adminById.getAdminPwd());
                user = new SecurityUser(admin);
            }
        } catch (Exception e) {

        }
        return user;
    }
}
