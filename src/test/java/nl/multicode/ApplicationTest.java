package nl.multicode;

import static nl.multicode.EnglishToOtherTranslator.DUTCH;
import static nl.multicode.EnglishToOtherTranslator.SWEDISH;
import static org.assertj.core.api.Assertions.assertThat;

import nl.multicode.util.TestAppender;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

        assertThat(englishToOtherTranslator.getTranslationFor(null, null))
            .isEqualTo("null word or language arguments are not allowed!");
        assertThat(TestAppender.count()).isZero();
    }

    @Test
    void logging() {

        englishToOtherTranslator.getTranslationFor("unknown", DUTCH);
        assertThat(TestAppender.getLogs(Level.INFO).get(0)).isEqualTo("requesting translation of unknown to dutch");
    }

    @ParameterizedTest
    @CsvSource({"hello,hallo", "cake,taart", "street,straat", "bye,doei"})
    void dutch(String word, String translation) {

        assertThat(englishToOtherTranslator.getTranslationFor(word, DUTCH)).isEqualTo(translation);
    }

    @ParameterizedTest
    @CsvSource({"hello,hallå", "cake,kaka", "street,gata", "bye,hejdå"})
    void swedish(String word, String translation) {

        assertThat(englishToOtherTranslator.getTranslationFor(word, SWEDISH)).isEqualTo(translation);
    }
}