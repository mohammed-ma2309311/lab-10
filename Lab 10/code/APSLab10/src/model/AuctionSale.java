package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Auction terms and the bids received (Lab 7 and Lab 8).
 */
public final class AuctionSale extends Sale {
    private final double startingPrice;
    private final LocalDateTime endsAt;
    private final List<Bid> bids = new ArrayList<>();

    public AuctionSale(double startingPrice, LocalDateTime endsAt) {
        if (startingPrice <= 0) {
            throw new IllegalArgumentException("The starting price must be greater than zero");
        }
        this.startingPrice = startingPrice;
        this.endsAt = endsAt;
    }

    /** UC006 steps 2 and 4: true while the auction accepts bids. */
    public boolean isOpen(LocalDateTime now) {
        return !now.isAfter(endsAt);
    }

    /** The last offered bid, or the starting price when there are no bids. */
    public double lastOfferedPrice() {
        if (bids.isEmpty()) {
            return startingPrice;
        }
        return bids.get(bids.size() - 1).getAmount();
    }

    /** Records an accepted bid. The bid must be on time and higher than the last offered price. */
    public void addBid(Bid bid) {
        if (!isOpen(bid.getPlacedAt())) {
            throw new IllegalStateException("The auction has ended");
        }
        if (bid.getAmount() <= lastOfferedPrice()) {
            throw new IllegalArgumentException("The bid must be greater than the last offered price");
        }
        bids.add(bid);
    }

    public List<Bid> getBids() {
        return new ArrayList<>(bids);
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public LocalDateTime getEndsAt() {
        return endsAt;
    }

    @Override
    public String describeTerms() {
        return String.format(Locale.ROOT, "Auction from QAR %.2f, ends %s", startingPrice, endsAt);
    }
}
