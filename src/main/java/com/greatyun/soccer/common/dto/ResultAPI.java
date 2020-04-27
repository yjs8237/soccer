package com.greatyun.soccer.common.dto;

public class ResultAPI {

    public static ApiResultDTO error (String description) {
        return ApiResultDTO.builder().result(-1).description(description).build();
    }
    public static ApiResultDTO success (String description) {
        return ApiResultDTO.builder().result(0).description(description).build();
    }
}
