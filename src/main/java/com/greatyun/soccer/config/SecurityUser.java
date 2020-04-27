package com.greatyun.soccer.config;

import com.greatyun.soccer.admin.domain.Admin;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SecurityUser extends User {

    private static final String ROLE_PREFIX = "ROLE_";

    public SecurityUser (Admin admin) {
//        super(admin.getAdminId() , admin.getAdminPwd() , Arrays.asList(new SimpleGrantedAuthority(getRole(admin.getRole().getKey()))));
        super(admin.getAdminId() , admin.getAdminPwd() , getRoles(admin));
    }

    private static String getRole(String key) {
        return ROLE_PREFIX + key;
    }

    private static List<SimpleGrantedAuthority> getRoles(Admin admin) {
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if(admin.getAdminId().equals("apiuser")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_RESTAPI"));
        } else if(admin.getAdminId().equals("greatyun")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_SUPER"));
        } else {
            authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + admin.getRole().getKey()));
        }
        return authorities;
    }

}
