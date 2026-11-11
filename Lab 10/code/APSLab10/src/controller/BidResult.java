package controller;

/** The outcome of UC006 Place bid. */
public enum BidResult {
    ACCEPTED,       // steps 5 and 6
    BID_TOO_LOW,    // 4.b
    AUCTION_ENDED   // 2.a and 4.a
}
