package com.eucl.dto;


public class MeterRegisterRequest {
    private String meterNumber;
    private Long userId;

    public MeterRegisterRequest() {}

    public MeterRegisterRequest(String meterNumber, Long userId) {
        this.meterNumber = meterNumber;
        this.userId = userId;
    }
    public String getMeterNumber() {
        return meterNumber;
    }
    public void setMeterNumber(String meterNumber) {
        this.meterNumber = meterNumber;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}


