package com.example.copilot.health;

import java.util.Random;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class PaymentGatewayHealthIndicator implements HealthIndicator {
    private final Random random = new Random();

    @Override
    public Health health() {
        boolean isUp = random.nextBoolean();
        if (isUp) {
            return Health.up().withDetail("paymentGateway", "Available").build();
        } else {
            return Health.down().withDetail("paymentGateway", "Unavailable").build();
        }
    }
}
