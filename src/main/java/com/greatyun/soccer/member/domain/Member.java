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

    @Column(name = "member_id" , length = 100)
    @NotNull
    private String memberId;

    @Column(name = "name" , length = 100)
    @NotNull
    private String name;

    @Column(name = "cell_no" , length = 45)
    @NotNull
    private String cellNo;

    @Column(name = "age")
    private int age;

    @Column(name = "back_number")
    private int backNumber;

    @Column(name = "img_url" , length = 255)
    private String imgUrl;

    @Column(name = "img_path" , length = 255)
    private String imgPath;

}
