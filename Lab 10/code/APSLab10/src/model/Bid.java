package model;

import java.time.LocalDateTime;

/**
 * A price offered for an item on auction. Amounts are in QAR.
 */
public final class Bid {
    private final double amount;
    private final LocalDateTime placedAt;

    public Bid(double amount, LocalDateTime placedAt) {
        if (amount <= 0) {
            throw new IllegalArgumentException("A bid must be greater than zero");
        }
        this.amount = amount;
        this.placedAt = placedAt;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getPlacedAt() {
        return placedAt;
    }
}
