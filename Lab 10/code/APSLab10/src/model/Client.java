package model;

import java.util.ArrayList;
import java.util.List;

/**
 * A registered APS client (Lab 7). The client's registration records the bids placed.
 */
public abstract class Client {
    private final int registrationNo;
    private final String name;
    private final String address;
    private final List<Bid> bids = new ArrayList<>();

    protected Client(int registrationNo, String name, String address) {
        this.registrationNo = registrationNo;
        this.name = name;
        this.address = address;
    }

    /** UC006 step 5: records the bid in the client's registration. */
    public void addBid(Bid bid) {
        bids.add(bid);
    }

    public List<Bid> getBids() {
        return new ArrayList<>(bids);
    }

    public int getRegistrationNo() {
        return registrationNo;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
