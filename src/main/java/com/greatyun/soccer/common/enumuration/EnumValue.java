package com.greatyun.soccer.common.enumuration;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EnumValue {


    private String key;
    private String value;

    public EnumValue(EnumModel enumModel) {
        this.key = enumModel.getKey();
        this.value = enumModel.getValue();
    }


}
