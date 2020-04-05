package com.greatyun.soccer.common.enumuration;

public enum EnumMatchStatus implements EnumModel {
    READY("대기중") , RESERVED("매치완료") , ING("경기중") , FINISH("종료");
    private String description;

    private EnumMatchStatus(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getValue() {
        return description;
    }
}
