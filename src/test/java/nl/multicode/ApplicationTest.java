package nl.multicode;

import static org.assertj.core.api.Assertions.assertThat;

import nl.multicode.util.TestAppender;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    void main_null() {

        Application.main(null);
        assertThat(TestAppender.getLogs(Level.INFO)).isEmpty();
    }

    @Test
    void main_empty() {

        Application.main(new String[]{});
        assertThat(TestAppender.getLogs(Level.INFO)).isEmpty();
    }

    @ParameterizedTest
    @CsvSource({"228996755,228996755 is an invalid bsn", "492015594,492015594 is a valid bsn"})
    void main_multiple_mix_valid_invalid_bsn(String input, String output) {

        Application.main(new String[]{input});
        assertThat(TestAppender.getLogs(Level.INFO).get(0)).contains(output);

    }

    @ParameterizedTest
    @ValueSource(strings = {"273517922", "492015594", "240200688", "879730584", "746889859", "911066226"})
    void main_multiple_valid_bsn(String input) {

        Application.main(new String[]{input});
        assertThat(TestAppender.getLogs(Level.INFO).get(0)).contains(input + " is a valid bsn");
    }

    @ParameterizedTest
    @ValueSource(strings = {"228996755", "492025594", "240220688", "379730584", "446889759", "951066226", "780368559"})
    void main_multiple_invalid_bsn(String input) {

        Application.main(new String[]{input});
        assertThat(TestAppender.getLogs(Level.INFO).get(0)).contains(input + " is an invalid bsn");
    }
}