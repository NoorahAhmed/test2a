package nl.multicode;

import static org.assertj.core.api.Assertions.assertThat;

import nl.multicode.util.TestAppender;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AnimalEncyclopediaTest {

    private AnimalEncyclopedia englishToOtherTranslator;

    @BeforeEach
    public void setup() {

        englishToOtherTranslator = new AnimalEncyclopedia();
        TestAppender.clear();
    }

    @AfterEach
    public void tearDown() {

        TestAppender.clear();
    }

    @Test
    void null_input() {

        englishToOtherTranslator.getTranslationFor(null);
        assertThat(TestAppender.getLogs(Level.INFO)).contains("null word or language arguments are not allowed!");
    }

    @Test
    void logging() {

        englishToOtherTranslator.getTranslationFor("unknown");
        assertThat(TestAppender.getLogs(Level.INFO)).contains("null word or language arguments are not allowed!");
    }

    @ParameterizedTest
    @CsvSource({"dog,hond", "bread,brood", "welcome,welkom", "bye,hejdå", "goodbye,adjö", "later,senare"})
    void swedish(String word, String output) {

        englishToOtherTranslator.getTranslationFor(word);
        assertThat(TestAppender.getLogs(Level.INFO)).contains("null word or language arguments are not allowed!");
    }
}