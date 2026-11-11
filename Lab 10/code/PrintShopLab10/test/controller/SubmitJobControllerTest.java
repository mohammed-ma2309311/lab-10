package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Document;
import model.JobStatus;
import model.PrintJobRepository;
import model.PrintingOptions;
import model.User;

class SubmitJobControllerTest {
    private PrintJobRepository jobs;
    private User user;
    private Document doc;

    @BeforeEach
    void setUp() {
        jobs = new PrintJobRepository();
        user = new User("s2026001", "Mariam");
        doc = new Document("Lab10.pdf", 10);
    }

    @Test
    void sufficientCreditQueuesAndSavesJob() {            // TC-A7, UC001 main flow
        StubPASGateway pas = new StubPASGateway(true);
        SubmitJobController submission = new SubmitJobController(pas, jobs);

        assertTrue(submission.submitJob(user, doc, new PrintingOptions(2, false, false)));
        assertEquals(5.00, pas.getCheckedAmount(), 0.001);
        assertEquals(1, jobs.findAll().size());
        assertEquals(JobStatus.QUEUED, jobs.findAll().get(0).getStatus());
    }

    @Test
    void insufficientCreditRejectsJob() {                 // TC-A8, UC001 5.a
        SubmitJobController submission = new SubmitJobController(new StubPASGateway(false), jobs);

        assertFalse(submission.submitJob(user, doc, new PrintingOptions(2, false, false)));
        assertTrue(jobs.findAll().isEmpty());
    }
}
