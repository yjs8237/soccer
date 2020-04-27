package com.greatyun.soccer.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResultDTO<T> {

    private int result;

    private String description;

    private T data;
}
