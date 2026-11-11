package model;

/**
 * A print job (Lab 7 and Lab 8). Prices are in QAR.
 */
public class PrintJob {
    public static final double BLACK_AND_WHITE_RATE = 0.25; // per page
    public static final double COLOUR_RATE = 1.00;          // per page
    public static final double DOUBLE_SIDED_FACTOR = 0.90;  // 10% discount

    private final User user;
    private final Document document;
    private final PrintingOptions options;
    private JobStatus status; // null until the job is queued
    private double cost;

    public PrintJob(User user, Document document, PrintingOptions options) {
        this.user = user;
        this.document = document;
        this.options = options;
    }

    /** Calculates, stores and returns the printing cost. */
    public double calculateCost() {
        double rate = options.isColour() ? COLOUR_RATE : BLACK_AND_WHITE_RATE;
        double factor = options.isDoubleSided() ? DOUBLE_SIDED_FACTOR : 1.0;
        cost = document.getPages() * options.getCopies() * rate * factor;
        return cost;
    }

    public void queue() {
        status = JobStatus.QUEUED;
    }

    public User getUser() {
        return user;
    }

    public Document getDocument() {
        return document;
    }

    public PrintingOptions getOptions() {
        return options;
    }

    public JobStatus getStatus() {
        return status;
    }

    public double getCost() {
        return cost;
    }
}
