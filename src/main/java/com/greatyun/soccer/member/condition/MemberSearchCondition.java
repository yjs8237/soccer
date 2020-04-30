package com.greatyun.soccer.member.condition;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class MemberSearchCondition {

    private String memberId;

    private String name;

    private String cellNo;

    private int age;

    private int backNumber;

    private String imgUrl;

    private String imgPath;
}
