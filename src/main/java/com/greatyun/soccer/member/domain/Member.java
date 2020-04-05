package com.greatyun.soccer.member.domain;

import com.greatyun.soccer.common.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_member")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Member extends BaseEntity {

    @Column(name = "name")
    @NotNull
    private String name;

}
