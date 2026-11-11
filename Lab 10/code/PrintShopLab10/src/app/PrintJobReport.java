package app;

import java.util.List;

import model.Document;
import model.PrintJob;
import model.PrintJobRepository;
import model.PrintingOptions;
import model.User;

/**
 * A.4 static analysis exercise. This class contains planted defects.
 * Run SpotBugs and SonarQube for IDE on it before running it.
 */
public class PrintJobReport {

    public static void main(String[] args) {
        PrintJobRepository jobs = new PrintJobRepository();
        User mariam = new User("s2026001", "Mariam");
        PrintingOptions twoCopies = new PrintingOptions(2, false, false);
        jobs.save(new PrintJob(mariam, new Document("Lab10.pdf", 12), twoCopies));
        jobs.save(new PrintJob(mariam, new Document("Poster.pdf", 1), twoCopies));
        List<PrintJob> all = jobs.findAll();

        String title = args.length > 0 ? args[0] : "Daily report";
        title.trim();
        if (title == "Daily report") {
            System.out.println("=== " + title + " ===");
        }

        for (int i = 0; i < all.size(); i--) {
            System.out.println(all.get(i).getDocument().getFileName());
        }

        int totalPages = 0;
        for (PrintJob job : all) {
            totalPages += job.getDocument().getPages();
        }
        double averagePages = totalPages / all.size();
        System.out.println("Average pages: " + averagePages);

        User owner = null;
        if (args.length > 1) {
            owner = new User(args[1], "Unknown");
        }
        System.out.println("Report owner: " + owner.getName());
    }
}
