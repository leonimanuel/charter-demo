package com.example.dumbstarbucks;

import com.example.dumbstarbucks.repository.TransactionRepository;
import com.example.dumbstarbucks.seeder.DatabaseSeeder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SeedDatabaseApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SeedDatabaseApplication.class, args);

        DatabaseSeeder databaseSeeder = context.getBean(DatabaseSeeder.class);
        TransactionRepository transactionRepository = context.getBean(TransactionRepository.class);

        databaseSeeder.seed(transactionRepository);
        context.close();
    }
}
