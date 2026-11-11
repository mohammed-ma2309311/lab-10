package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores print jobs in memory (Lab 8).
 */
public class PrintJobRepository {
    private final List<PrintJob> jobs = new ArrayList<>();

    public void save(PrintJob job) {
        if (!jobs.contains(job)) {
            jobs.add(job);
        }
    }

    public List<PrintJob> findAll() {
        return new ArrayList<>(jobs);
    }
}
