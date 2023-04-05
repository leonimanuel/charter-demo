package com.example.dumbstarbucks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.example.dumbstarbucks.model.Transaction;
import com.example.dumbstarbucks.service.RewardService;

@RestController
// @RequestMapping("/api/transactions")
public class TransactionController {

    private final RewardService rewardService;

    @Autowired
    public TransactionController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @GetMapping("/api/transactions/rewards")
    public Map<String, Integer> getCustomerRewards(@RequestParam("startDate") String start, @RequestParam("endDate") String end) {
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        
        List<Transaction> transactions = getSampleTransactions();
        System.out.println("Hello, World!");
        return calculateCustomerRewards(transactions, startDate, endDate);
    }

    private List<Transaction> getSampleTransactions() {
        List<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction("C1", LocalDate.of(2023, 1, 5), 75.0));
        transactions.add(new Transaction("C2", LocalDate.of(2023, 1, 10), 120.0));
        transactions.add(new Transaction("C1", LocalDate.of(2023, 1, 20), 150.0));
        transactions.add(new Transaction("C3", LocalDate.of(2023, 1, 25), 200.0));
        transactions.add(new Transaction("C1", LocalDate.of(2023, 2, 5), 50.0));
        transactions.add(new Transaction("C2", LocalDate.of(2023, 2, 15), 90.0));
        transactions.add(new Transaction("C3", LocalDate.of(2023, 2, 25), 300.0));
        transactions.add(new Transaction("C1", LocalDate.of(2023, 3, 5), 110.0));
        transactions.add(new Transaction("C2", LocalDate.of(2023, 3, 10), 60.0));
        transactions.add(new Transaction("C3", LocalDate.of(2023, 3, 20), 250.0));

        return transactions;
    }

    private Map<String, Integer> calculateCustomerRewards(List<Transaction> transactions, LocalDate startDate, LocalDate endDate) {
        Map<String, Integer> customerRewards = new HashMap<>();

        for (Transaction transaction : transactions) {
            if (transaction.getTransactionDate().isAfter(startDate) && transaction.getTransactionDate().isBefore(endDate)) {
                int points = rewardService.calculateRewardPoints(transaction.getAmount());
                customerRewards.merge(transaction.getCustomerId(), points, Integer::sum);
            }
        }

        return customerRewards;
    }    
}
