package model;

/**
 * Printing options chosen by the user (Lab 7).
 */
public final class PrintingOptions {
    public static final int MAX_COPIES = 50;

    private final int copies;
    private final boolean colour;
    private final boolean doubleSided;

    public PrintingOptions(int copies, boolean colour, boolean doubleSided) {
        // A.3: the failing tests show that copies must be checked here.
        this.copies = copies;
        this.colour = colour;
        this.doubleSided = doubleSided;
    }

    public int getCopies() {
        return copies;
    }

    public boolean isColour() {
        return colour;
    }

    public boolean isDoubleSided() {
        return doubleSided;
    }
}
