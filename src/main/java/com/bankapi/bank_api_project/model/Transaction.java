package com.bankapi.bank_api_project.model;

import java.time.LocalDateTime;

public class Transaction {
    private String description;
    private double amount;
    private LocalDateTime timestamp;

    public Transaction(String description, double amount) {
        this.description = description;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}