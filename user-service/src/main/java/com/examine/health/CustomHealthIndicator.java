package com.examine.health;


import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        // Replace with your own check (e.g., DB or API)
        boolean healthy = true;
        if (healthy) {
            return Health.up().withDetail("custom", "All good!").build();
        } else {
            return Health.down().withDetail("custom", "Something's wrong").build();
        }
    }
}
