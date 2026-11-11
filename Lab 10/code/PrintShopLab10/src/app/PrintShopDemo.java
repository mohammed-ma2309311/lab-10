package app;

import controller.SubmitJobController;
import model.Document;
import model.PrintJob;
import model.PrintJobRepository;
import model.PrintingOptions;
import model.User;

/**
 * Runs UC001 twice: one job is accepted, one is rejected for insufficient credit.
 */
public class PrintShopDemo {

    public static void main(String[] args) {
        SimulatedPAS pas = new SimulatedPAS();
        pas.setBalance("s2026001", 20.00);
        PrintJobRepository jobs = new PrintJobRepository();
        SubmitJobController submission = new SubmitJobController(pas, jobs);
        User mariam = new User("s2026001", "Mariam");

        Document notes = new Document("Lab10.pdf", 10);
        Document poster = new Document("Poster.pdf", 10);
        submit(submission, mariam, notes, new PrintingOptions(2, false, false));  // QAR 5.00
        submit(submission, mariam, poster, new PrintingOptions(3, true, true));   // QAR 27.00

        System.out.println("Queued jobs:");
        for (PrintJob job : jobs.findAll()) {
            System.out.printf("  %s  %s  QAR %.2f%n",
                    job.getDocument().getFileName(), job.getStatus(), job.getCost());
        }
    }

    private static void submit(SubmitJobController submission, User user, Document doc,
            PrintingOptions options) {
        boolean accepted = submission.submitJob(user, doc, options);
        System.out.println(doc.getFileName() + ": "
                + (accepted ? "accepted and queued" : "rejected - insufficient credit"));
    }
}
