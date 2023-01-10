package nl.multicode;


import nl.multicode.util.TestAppender;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest {

    @BeforeEach
    public void setup() {

        TestAppender.clear();
    }

    @AfterEach
    public void tearDown() {

        TestAppender.clear();
    }

    @Test
    void combine() {
        new Application().execute("combine", "Dirty", "Code");
        assertThat(TestAppender.getLogs(Level.INFO).get(0)).contains("Combined firstArgument 'Dirty' and secondArgument 'Code' and resulted in 'DirtyCode'");
    }

    @Test
    void combineToUppercase() {
        new Application().execute("combineToUppercase", "Dirty", "Code");

        assertThat(TestAppender.getLogs(Level.INFO).get(0)).contains("Combined to uppercase firstArgument 'Dirty' and secondArgument 'Code' resulted in 'DIRTY_CODE'");
    }

    @Test
    void unknownCommand() {
        new Application().execute("unknown", "Dirty", "Code");

        assertThat(TestAppender.getLogs(Level.INFO)).isEmpty();
    }
}