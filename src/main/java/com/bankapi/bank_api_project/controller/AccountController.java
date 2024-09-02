package com.bankapi.bank_api_project.controller;

import com.bankapi.bank_api_project.model.Account;
import com.bankapi.bank_api_project.model.Transaction;
import com.bankapi.bank_api_project.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestParam String accountNumber, @RequestParam double initialBalance) {
        Account account = accountService.createAccount(accountNumber, initialBalance);
        return ResponseEntity.ok(account);
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Account> getAccount(@PathVariable String accountNumber) {
        Account account = accountService.getAccount(accountNumber);
        if (account != null) {
            return ResponseEntity.ok(account);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @PostMapping("/{accountNumber}/deposit")
    public ResponseEntity<Void> deposit(@PathVariable String accountNumber, @RequestParam double amount) {
        accountService.deposit(accountNumber, amount);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{accountNumber}/withdraw")
    public ResponseEntity<Void> withdraw(@PathVariable String accountNumber, @RequestParam double amount) {
        try {
            accountService.withdraw(accountNumber, amount);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{accountNumber}/transactions")
    public ResponseEntity<List<Transaction>> getTransactionHistory(@PathVariable String accountNumber) {
        List<Transaction> transactions = accountService.getTransactionHistory(accountNumber);
        return ResponseEntity.ok(transactions);
    }
}