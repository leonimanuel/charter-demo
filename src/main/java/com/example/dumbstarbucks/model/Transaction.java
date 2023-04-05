package com.example.dumbstarbucks.model;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaction {
    private String customerId;
    private LocalDate transactionDate;
    private double amount;

    public Transaction(String customerId, LocalDate transactionDate, double amount) {
        this.customerId = customerId;
        this.transactionDate = transactionDate;
        this.amount = amount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public Double getAmount() {
        return amount;
    }    
}