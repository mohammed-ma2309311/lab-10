package controller;

import model.Document;
import model.PASGateway;
import model.PrintJob;
import model.PrintJobRepository;
import model.PrintingOptions;
import model.User;

/**
 * UC001 Submit print job, as designed in Lab 8 (Figure 1).
 */
public class SubmitJobController {
    private final PASGateway gateway;
    private final PrintJobRepository jobs;

    public SubmitJobController(PASGateway gateway, PrintJobRepository jobs) {
        this.gateway = gateway;
        this.jobs = jobs;
    }

    /** Returns true if the job is accepted and queued, false if credit is insufficient (5.a). */
    public boolean submitJob(User user, Document doc, PrintingOptions options) {
        PrintJob job = new PrintJob(user, doc, options);
        double cost = job.calculateCost();
        if (!gateway.checkCredit(user.getUserId(), cost)) {
            return false;
        }
        job.queue();
        jobs.save(job);
        return true;
    }
}
