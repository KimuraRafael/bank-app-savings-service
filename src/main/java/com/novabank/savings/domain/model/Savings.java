package com.novabank.savings.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class  Savings {

    private String id;
    private String userId;
    private String description;
    private BigDecimal targetAmount;
    private BigDecimal balance;
    private LocalDateTime createdAt;

    Savings(){
    }

    public Savings(String id, String userId, String description, BigDecimal balance, BigDecimal targetAmount, LocalDateTime createdAt) {

        this.id = id;
        this.userId = userId;
        this.description = description;
        this.balance =balance;
        this.targetAmount = targetAmount;
        this.createdAt = createdAt;
    }

    public static Savings create(String userId, String description,BigDecimal targetAmount){

        if (userId == null || userId.isBlank()) {
            throw new IllegalArgumentException("User id cannot be empty");
        }

        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be empty");
        }

        if (targetAmount == null || targetAmount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Target amount must be greater than zero");
        }

        return new Savings(
                UUID.randomUUID().toString(),
                userId,
                description,
                BigDecimal.ZERO,
                targetAmount,
                LocalDateTime.now());
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
        return createdAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createdAt = createAt;
    }
}
