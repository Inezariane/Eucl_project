package com.eucl.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "notifications")
public class Notification {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 6, unique = true)
    private String meterNumber;

    private String message;

    private LocalDateTime issuedDate;

    @ManyToOne
    @JoinColumn(name = "meterId", nullable = false)
    private Meter meter;

    public Notification() {}

    public Notification(String meterNumber, String message, LocalDateTime issuedDate) {
        this.meterNumber = meterNumber;
        this.message = message;
        this.issuedDate = issuedDate;
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
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public LocalDateTime getIssuedDate() {
        return issuedDate;
    }
    public void setIssuedDate(LocalDateTime issuedDate) {
        this.issuedDate = issuedDate;
    }
    public Meter getMeter() {
        return meter;
    }
    public void setMeter(Meter meter) {
        this.meter = meter;
    }
    
}
