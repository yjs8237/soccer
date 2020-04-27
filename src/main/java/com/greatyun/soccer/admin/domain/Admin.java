package com.greatyun.soccer.admin.domain;

import com.greatyun.soccer.common.domain.BaseEntity;
import com.greatyun.soccer.common.enumuration.ROLE;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_admin")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Admin extends BaseEntity {

    @Column(name = "admin_id" , length = 100)
    @NotNull
    private String adminId;

    @Column(name = "admin_pwd")
    @NotNull
    private String adminPwd;

    @Column(name = "role")
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private ROLE role;



}
