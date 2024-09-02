package com.bankapi.bank_api_project.service;

import com.bankapi.bank_api_project.model.Account;
import com.bankapi.bank_api_project.model.Transaction;

import java.util.List;

public interface AccountService {
    Account createAccount(String accountNumber, double initialBalance);
    Account getAccount(String accountNumber);
    List<Account> getAllAccounts();
    void deposit(String accountNumber, double amount);
    void withdraw(String accountNumber, double amount);
    List<Transaction> getTransactionHistory(String accountNumber);
}