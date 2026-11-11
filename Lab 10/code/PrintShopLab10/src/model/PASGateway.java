package model;

/**
 * Connection to the external Print Account System (PAS). An interface lets a
 * test replace the real PAS with a stub.
 */
public interface PASGateway {
    /** UC006: true if the user's available credit covers the amount. */
    boolean checkCredit(String userId, double amount);
}
