package com.greatyun.soccer.admin.repository;

import com.greatyun.soccer.admin.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface AdminRepository extends JpaRepository<Admin , Long> {

    public Optional<Admin> findByAdminId(String adminId);

}
