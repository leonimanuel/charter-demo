package com.example.dumbstarbucks.service;

import org.springframework.stereotype.Service;

@Service
public class RewardService {

    public int calculateRewardPoints(double amount) {
        int points = 0;
        if (amount > 100) {
            points += 2 * (amount - 100);
            amount = 100;
        }
        if (amount > 50) {
            points += (amount - 50);
        }
        return points;
    }
}
