package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrintJobTest {
    private User user;
    private Document doc;

    @BeforeEach
    void setUp() {
        user = new User("s2026001", "Mariam");
        doc = new Document("Lab10.pdf", 10);
    }

    @Test
    void blackAndWhiteSingleSidedCost() {                 // TC-A1
        PrintJob job = new PrintJob(user, doc, new PrintingOptions(2, false, false));
        assertEquals(5.00, job.calculateCost(), 0.001);
    }

    @Test
    void colourDoubleSidedCostIncludesDiscount() {        // TC-A2
        PrintJob job = new PrintJob(user, doc, new PrintingOptions(1, true, true));
        assertEquals(9.00, job.calculateCost(), 0.001);
    }

    @Test
    void jobIsQueuedOnlyAfterQueue() {                    // TC-A3
        PrintJob job = new PrintJob(user, doc, new PrintingOptions(1, false, false));
        assertNull(job.getStatus());
        job.queue();
        assertEquals(JobStatus.QUEUED, job.getStatus());
    }
}
