package nl.multicode;

import nl.multicode.util.TestAppender;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
    void main_file_exists() {
        Application.main(new String[]{"src/test/resources/shorttest.csv"});
        assertThat(TestAppender.getLogs(Level.INFO)).contains("Application start: ----------- :");
        assertThat(TestAppender.getLogs(Level.INFO)).contains("execute reading: src/test/resources/shorttest.csv:");
        assertThat(TestAppender.getLogs(Level.INFO)).contains("Persons from file: Person(name=Jamie, birthDate=11-02-2020, hair=brunette)\n");
        assertThat(TestAppender.getLogs(Level.INFO)).contains("Application finish: ----------- :");
    }

    @Test
    void main_no_file_provided() {
        Application.main(new String[]{});
        assertThat(TestAppender.getLogs(Level.INFO)).contains("Application start: ----------- :");
        assertThat(TestAppender.getLogs(Level.INFO)).contains("No csv file provided to read!");
        assertThat(TestAppender.getLogs(Level.INFO)).contains("Application finish: ----------- :");
    }
}