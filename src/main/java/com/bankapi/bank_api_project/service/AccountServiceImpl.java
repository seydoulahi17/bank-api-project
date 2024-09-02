package com.bankapi.bank_api_project.service;

import com.bankapi.bank_api_project.model.Account;
import com.bankapi.bank_api_project.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {
    private Map<String, Account> accounts = new HashMap<>();

    @Override
    public Account createAccount(String accountNumber, double initialBalance) {
        Account account = new Account(accountNumber, initialBalance);
        accounts.put(accountNumber, account);
        return account;
    }

    @Override
    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    @Override
    public List<Account> getAllAccounts() {
        return new ArrayList<>(accounts.values());
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
        }
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        }
    }

    @Override
    public List<Transaction> getTransactionHistory(String accountNumber) {
        Account account = getAccount(accountNumber);
        return account != null ? account.getTransactions() : new ArrayList<>();
    }
}