package com.novabank.savings.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Savings {

    private String id;
    private String userId;
    private String description;
    private BigDecimal targetAmount;
    private BigDecimal balance;
    private LocalDateTime createAt;

    Savings(){
    }

    public Savings(String id, String userId, String description, BigDecimal balance, BigDecimal targetAmount, LocalDateTime createAt) {
        this.id = id;
        this.userId = userId;
        this.description = description;
        this.balance = balance;
        this.targetAmount = targetAmount;
        this.createAt = createAt;
    }

    public static Savings create(String userId, String description, BigDecimal balance, BigDecimal targetAmount, LocalDateTime createAt){

        return new Savings(UUID.randomUUID().toString(), userId, description, balance,
                targetAmount, createAt);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(BigDecimal targetAmount) {
        this.targetAmount = targetAmount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
}
