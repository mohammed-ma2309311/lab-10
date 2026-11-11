package app;

import java.time.LocalDateTime;
import java.util.List;

import controller.BidResult;
import model.AuctionSale;
import model.Bid;
import model.Client;
import model.IndividualClient;

/**
 * Prints a short report on one client's bids in an auction.
 * B3: analyse this class with SpotBugs and SonarQube for IDE.
 */
public class BidReport {

    public static String summary(AuctionSale auction, Client buyer, String lastResult) {
        StringBuilder text = new StringBuilder("Bids by " + buyer.getName() + "\n");

        List<Bid> bids = buyer.getBids();
        Bid highest = null;
        if (bids.size() == 0) {
            text.append("No bids yet\n");
        } else {
            highest = bids.get(0);
            for (Bid bid : bids) {
                if (bid.getAmount() > highest.getAmount()) {
                    highest = bid;
                }
            }
        }
        text.append("Highest bid: QAR ").append(highest.getAmount()).append("\n");

        if (highest.getAmount() == auction.lastOfferedPrice()) {
            text.append("Leading bidder\n");
        }
        if (lastResult.equals(BidResult.ACCEPTED)) {
            text.append("Last bid accepted\n");
        }
        // text.append("Address: ").append(buyer.getAddress()).append("\n");
        return text.toString();
    }

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.of(2026, 11, 19, 10, 0);
        AuctionSale auction = new AuctionSale(800, now.plusDays(1));
        Client aisha = new IndividualClient(1001, "Aisha", "Doha");
        Bid bid = new Bid(850, now);
        auction.addBid(bid);
        aisha.addBid(bid);
        System.out.print(summary(auction, aisha, "ACCEPTED"));
    }
}
