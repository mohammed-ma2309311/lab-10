package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PrintingOptionsTest {

    @Test
    void zeroCopiesIsRejected() {                         // TC-A4
        assertThrows(IllegalArgumentException.class, () -> new PrintingOptions(0, false, false));
    }

    @Test
    void maximumCopiesIsAccepted() {                      // TC-A5
        assertEquals(50, new PrintingOptions(50, false, false).getCopies());
    }

    @Test
    void moreThanMaximumCopiesIsRejected() {              // TC-A6
        assertThrows(IllegalArgumentException.class, () -> new PrintingOptions(51, false, false));
    }
}
