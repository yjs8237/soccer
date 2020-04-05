package com.greatyun.soccer.common.util;

public class CommException extends Exception {

    private String reason;

    public CommException(String reason) {
        super(reason);
        this.reason = reason;
    }

    @Override
    public String getMessage() {
        return this.reason;
    }
}
