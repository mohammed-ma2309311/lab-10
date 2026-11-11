package controller;

import model.PASGateway;

/** Replaces PAS in tests: returns a fixed answer and remembers the amount checked. */
class StubPASGateway implements PASGateway {
    private final boolean sufficient;
    private double checkedAmount = -1;

    StubPASGateway(boolean sufficient) {
        this.sufficient = sufficient;
    }

    @Override
    public boolean checkCredit(String userId, double amount) {
        checkedAmount = amount;
        return sufficient;
    }

    double getCheckedAmount() {
        return checkedAmount;
    }
}
