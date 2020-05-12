package com.greatyun.soccer.config.security;

import com.greatyun.soccer.admin.domain.Admin;
import com.greatyun.soccer.common.enumuration.ROLE;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class SecurityUser extends User {

    private static final String ROLE_PREFIX = "ROLE_";

    public SecurityUser (Admin admin) {
//        super(admin.getAdminId() , admin.getAdminPwd() , Arrays.asList(new SimpleGrantedAuthority(getRole(admin.getRole().getKey()))));
        super(admin.getAdminId() , admin.getAdminPwd() , getRoles(admin.getRoles()));
    }

    private static String getRole(String key) {
        return ROLE_PREFIX + key;
    }

    private static List<SimpleGrantedAuthority> getRoles(Set<ROLE> roles) {
        return roles.stream().map(x -> new SimpleGrantedAuthority(ROLE_PREFIX + x.getValue())).collect(Collectors.toList());
    }

    private static List<SimpleGrantedAuthority> getRoles(Admin admin) {
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if(admin.getAdminId().equals("apiuser")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_RESTAPI"));
        } else if(admin.getAdminId().equals("greatyun")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_SUPER"));
        } else {
            //authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + admin.getRole().getKey()));
        }
        admin.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.getValue())));
        return authorities;
    }

}
