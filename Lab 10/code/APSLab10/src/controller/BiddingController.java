package controller;

import java.time.LocalDateTime;

import model.AuctionSale;
import model.Bid;
import model.Client;

/**
 * UC006 Place bid, following the Lab 8 design. Lab 10 simplification: the
 * controller receives the auction and the buyer that ItemCatalog.find() and
 * ClientContainer.find() would return.
 */
public class BiddingController {
    private AuctionSale selectedAuction;

    /** Steps 1 and 2: returns true if the auction is open (2.a when false). */
    public boolean selectAuction(AuctionSale auction, LocalDateTime now) {
        selectedAuction = auction;
        return auction.isOpen(now);
    }

    /** Step 2: the price the buyer must exceed. */
    public double getLastOfferedPrice() {
        return requireSelection().lastOfferedPrice();
    }

    /** Steps 3 to 6 with alternative flows 4.a and 4.b. */
    public BidResult placeBid(Client buyer, double amount, LocalDateTime now) {
        AuctionSale auction = requireSelection();
        if (!auction.isOpen(now)) {
            return BidResult.AUCTION_ENDED;
        }
        if (amount < auction.lastOfferedPrice()) {
            return BidResult.BID_TOO_LOW;
        }
        Bid bid = new Bid(amount, now);
        auction.addBid(bid);
        return BidResult.ACCEPTED;
    }

    private AuctionSale requireSelection() {
        if (selectedAuction == null) {
            throw new IllegalStateException("Select an auction first");
        }
        return selectedAuction;
    }
}
