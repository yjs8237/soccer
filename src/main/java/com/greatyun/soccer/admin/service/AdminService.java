package com.greatyun.soccer.admin.service;

import com.greatyun.soccer.admin.domain.Admin;
import com.greatyun.soccer.admin.repository.AdminRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Transactional(readOnly = true)
    public Optional<Admin> findAdminByAdminId (String adminId) {
        return adminRepository.findByAdminId(adminId);
    }
}
