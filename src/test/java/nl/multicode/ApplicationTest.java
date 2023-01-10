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

        final var result = new Application().execute("combine", "Dirty", "Code");
        assertThat(result).isEqualTo("DirtyCode");
        assertThat(TestAppender.getLogs(Level.INFO).get(0)).contains("Combined firstArgument 'Dirty' and secondArgument 'Code' and resulted in 'DirtyCode'");
    }

    @Test
    void combineToUppercase() {

        final var result = new Application().execute("combineToUppercase", "Dirty", "Code");
        assertThat(result).isEqualTo("DIRTY_CODE");
        assertThat(TestAppender.getLogs(Level.INFO).get(0)).contains("Combined to uppercase firstArgument 'Dirty' and secondArgument 'Code' resulted in 'DIRTY_CODE'");
    }

    @Test
    void unknownCommand() {

        final var result = new Application().execute("unknown", "Dirty", "Code");
        assertThat(result).isNull();
        assertThat(TestAppender.getLogs(Level.INFO)).isEmpty();
    }
}