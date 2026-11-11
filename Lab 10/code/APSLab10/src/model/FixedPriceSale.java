package model;

import java.util.Locale;

public final class FixedPriceSale extends Sale {
    private final double price;

    public FixedPriceSale(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("The price must be greater than zero");
        }
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String describeTerms() {
        return String.format(Locale.ROOT, "Fixed price QAR %.2f", price);
    }
}
