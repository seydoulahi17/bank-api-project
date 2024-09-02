package com.bankapi.bank_api_project.model;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private double balance;
    private List<Transaction> transactions;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        addTransaction(new Transaction("Initial deposit", initialBalance));
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    public void deposit(double amount) {
        balance += amount;
        addTransaction(new Transaction("Deposit", amount));
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            addTransaction(new Transaction("Withdrawal", -amount));
        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }

    private void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}