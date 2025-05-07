package com.eucl.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "meters")
public class Meter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 6, unique = true)
    private String meterId;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private User owner;

    @OneToMany(mappedBy = "meter", cascade = CascadeType.ALL)
    private List<Token> tokens;

    public Meter() {}

    public Meter(String meterId, User owner) {
        this.meterId = meterId;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMeterId() {
        return meterId;
    }
    public void setMeterId(String meterId) {
        this.meterId = meterId;
    }
    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }
    public List<Token> getTokens() {
        return tokens;
    }
    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }
}
