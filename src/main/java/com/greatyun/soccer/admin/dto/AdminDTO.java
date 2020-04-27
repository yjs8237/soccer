package com.greatyun.soccer.admin.dto;

import com.greatyun.soccer.common.enumuration.ROLE;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class AdminDTO {

    @NotNull
    private String adminId;

    private String adminPwd;

    private ROLE role;
}
