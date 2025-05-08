package com.eucl.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "purchased_tokens")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 6, unique = true)
    private String meterNumber;

    @Column(length = 16)
    private String token;

    @Enumerated(EnumType.STRING)
    private TokenStatus tokenStatus;

    private int tokenValueDays;

    private LocalDateTime purchasedDate;

    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "meterId", nullable = false)
    private Meter meter;

    public Token() {}

    public Token(String meterNumber, String token, TokenStatus tokenStatus, int tokenValueDays, LocalDateTime purchasedDate, Integer amount) {
        this.meterNumber = meterNumber;
        this.token = token;
        this.tokenStatus = tokenStatus;
        this.tokenValueDays = tokenValueDays;
        this.purchasedDate = purchasedDate;
        this.amount = amount;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }   
    public String getMeterNumber() {
        return meterNumber;
    }
    public void setMeterNumber(String meterNumber) {
        this.meterNumber = meterNumber;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public TokenStatus getTokenStatus() {
        return tokenStatus;
    }
    public void setTokenStatus(TokenStatus tokenStatus) {
        this.tokenStatus = tokenStatus;
    }
    public int getTokenValueDays() {
        return tokenValueDays;
    }
    public void setTokenValueDays(int tokenValueDays) {
        this.tokenValueDays = tokenValueDays;
    }
    public LocalDateTime getPurchasedDate() {
        return purchasedDate;
    }
    public void setPurchasedDate(LocalDateTime purchasedDate) {
        this.purchasedDate = purchasedDate;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public Meter getMeter() {
        return meter;
    }
    public void setMeter(Meter meter) {
        this.meter = meter;
    }
}
