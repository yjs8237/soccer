package com.greatyun.soccer.member.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberDTO {

    private String memberId;

    private String name;

    private String cellNo;

    private int age;

    private int backNumber;

    private String imgUrl;

    private String imgPath;

    @QueryProjection
    public MemberDTO (String memberId , String name , String cellNo , int age , int backNumber , String imgUrl , String imgPath) {
        this.memberId = memberId;
        this.name = name;
        this.cellNo = cellNo;
        this.age = age;
        this.backNumber = backNumber;
        this.imgPath = imgPath;
        this.imgUrl = imgUrl;
    }

    public MemberDTO nameChange() {
        this.name = "test";
        return this;
    }
}
