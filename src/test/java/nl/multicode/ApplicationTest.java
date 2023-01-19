package nl.multicode;

import static org.assertj.core.api.Assertions.assertThat;

import nl.multicode.util.TestAppender;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ApplicationTest {

    private Application application;

    @BeforeEach
    public void setup() {

        application = new Application();
        TestAppender.clear();
    }

    @AfterEach
    public void tearDown() {

        TestAppender.clear();
    }

    @Test
    void null_input() {

        application.getAnimalSound(null);
        assertThat(application.getAnimalSound(null)).isEqualTo("null animal argument is not allowed!");
        assertThat(TestAppender.count()).isZero();
    }

    @Test
    void logging() {

        application.getAnimalSound("unknown");
        assertThat(TestAppender.getLogs(Level.INFO).get(0)).isEqualTo("requesting sound of unknown");
    }

    @Test
    void cat() {

        assertThat(application.getAnimalSound("cat")).isEqualTo("meow");
    }

    @Test
    void dog() {

        assertThat(application.getAnimalSound("dog")).isEqualTo("bark");
    }

    @Test
    void dolphin() {

        assertThat(application.getAnimalSound("dolphin")).isEqualTo("click");
    }

    @Test
    void cow() {

        assertThat(application.getAnimalSound("cow")).isEqualTo("moo");
    }

    @Test
    void hyena() {

        assertThat(application.getAnimalSound("hyena")).isEqualTo("laugh");
    }

    @Test
    void dove() {

        assertThat(application.getAnimalSound("dove")).isEqualTo("coo");
    }

    @Test
    void chicken() {

        assertThat(application.getAnimalSound("chicken")).isEqualTo("cackle");
    }

    @Test
    void unknown() {

        assertThat(application.getAnimalSound("something")).isEqualTo("unknown");
    }
}