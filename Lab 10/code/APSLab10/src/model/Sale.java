package model;

/**
 * The sale terms of an item (Lab 7): fixed price or auction.
 */
public abstract class Sale {

    /** Text shown in the catalog, for example "Fixed price QAR 1200.00". */
    public abstract String describeTerms();
}
