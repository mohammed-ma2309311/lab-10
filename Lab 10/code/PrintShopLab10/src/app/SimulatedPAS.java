package app;

import java.util.HashMap;
import java.util.Map;

import model.PASGateway;

/**
 * Stands in for the real PAS when the demo runs. Balances are in QAR.
 */
public class SimulatedPAS implements PASGateway {
    private final Map<String, Double> balances = new HashMap<>();

    public void setBalance(String userId, double balance) {
        balances.put(userId, balance);
    }

    @Override
    public boolean checkCredit(String userId, double amount) {
        return balances.getOrDefault(userId, 0.0) >= amount;
    }
}
