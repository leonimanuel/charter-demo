package com.example.dumbstarbucks.seeder;

import com.example.dumbstarbucks.model.Transaction;
import com.example.dumbstarbucks.repository.TransactionRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseSeeder {

    public void seed(TransactionRepository transactionRepository) {
        List<Transaction> transactions = Arrays.asList(
                // new Transaction("C1", LocalDate.of(2023, 1, 5), 75.0),
                // new Transaction("C2", LocalDate.of(2023, 1, 10), 120.0),
                // new Transaction("C1", LocalDate.of(2023, 1, 20), 150.0),
                // new Transaction("C3", LocalDate.of(2023, 1, 25), 200.0),
                // new Transaction("C1", LocalDate.of(2023, 2, 5), 50.0),
                // new Transaction("C2", LocalDate.of(2023, 2, 15), 90.0),
                // new Transaction("C3", LocalDate.of(2023, 2, 25), 300.0),
                // new Transaction("C1", LocalDate.of(2023, 3, 5), 110.0),
                // new Transaction("C2", LocalDate.of(2023, 3, 10), 60.0),
                // new Transaction("C3", LocalDate.of(2023, 3, 20), 250.0)
        );

        transactionRepository.saveAll(transactions);
    }
}