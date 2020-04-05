package com.greatyun.soccer.common.dto;


import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DataTableDTO {

    private String myAdminId;

    private String recCode;

    private String type;

    private int result;
    private String msg;
    private String description;

    private String search;

    private String searchValue;

    private String searchType;

    private String language;

    private int draw;

    private int start;

    private int length;

    private String filter;

    private String orderColumn;

    private String orderDir;

    private String recordsTotal;

    private String recordsFiltered;

    private List data = new ArrayList();


}
