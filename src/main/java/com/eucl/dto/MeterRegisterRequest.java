package com.eucl.dto;


public class MeterRegisterRequest {
    private Long userId;

    public MeterRegisterRequest() {}

    public MeterRegisterRequest(String meterNumber, Long userId) {
        this.userId = userId;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}


