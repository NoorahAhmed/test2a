package nl.multicode;

import nl.multicode.util.TestAppender;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest {

    private EnglishToOtherTranslator englishToOtherTranslator;

    @BeforeEach
    public void setup() {

        englishToOtherTranslator = new EnglishToOtherTranslator();
        TestAppender.clear();
    }

    @AfterEach
    public void tearDown() {

        TestAppender.clear();
    }

    @Test
    void null_input() {

        assertThat(englishToOtherTranslator.getTranslationFor(null))
                .isEqualTo("null word or language arguments are not allowed!");
        assertThat(TestAppender.count()).isZero();
    }

    @Test
    void logging() {

        englishToOtherTranslator.getTranslationFor("unknown");
        assertThat(TestAppender.getLogs(Level.INFO).get(0)).isEqualTo("requesting translation of unknown to swedish");
    }

    @ParameterizedTest
    @CsvSource({"hello,hallå", "hi,hej", "welcome,välkommen", "bye,hejdå", "goodbye,adjö", "later,senare"})
    void swedish(String word, String translation) {

        assertThat(englishToOtherTranslator.getTranslationFor(word)).isEqualTo(translation);
    }

    @ParameterizedTest
    @CsvSource({"bla"})
    void unknownLanguage(String word) {

        assertThat(englishToOtherTranslator.getTranslationFor(word))
                .isEqualTo("unknown translation for word '" + word + "'");
    }
}