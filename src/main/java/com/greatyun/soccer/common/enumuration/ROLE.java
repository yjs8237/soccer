package com.greatyun.soccer.common.enumuration;

public enum ROLE implements EnumModel  {
    MANAGER("매니저") , RESTAPI("API") , SUPER("최고관리자") , PARTNER("파트너관리자") , USER("일반유저") , EMPLOYEE("직원");
    private String description;

    private ROLE(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    @Override
    public String getKey() {
        return null;
    }

    @Override
    public String getValue() {
        return null;
    }
}
