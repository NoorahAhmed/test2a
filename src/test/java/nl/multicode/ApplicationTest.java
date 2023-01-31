package nl.multicode;

import static org.assertj.core.api.Assertions.assertThat;

import nl.multicode.model.Animal;
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
    void test_empty_name() {

        assertThat(application.getAnimalSound(null)).isEqualTo("null animal argument is not allowed!");
    }

    @Test
    void test_empty_argument() {

        Application.main(null);
        assertThat(TestAppender.count()).isEqualTo(0);
    }

    @Test
    void test_valid_argument() {

        Application.main(new String[]{"cat"});
        assertThat(TestAppender.getLogs(Level.INFO).get(0)).isEqualTo("requesting sound of cat");
    }

    @Test
    void logging() {
        final var unknownName = "unknown";
        final var unknownSound = "unknownSound";
        final Animal animal = getAnimal(unknownName, unknownSound);

        final var animalSound = application.getAnimalSound(animal);
        assertThat(animalSound).isEqualTo(unknownSound);
        assertThat(TestAppender.getLogs(Level.INFO).get(0)).isEqualTo("requesting sound of unknown");
    }

    private static Animal getAnimal(String unknownName, String unknownSound) {

        final var animal = new Animal() {
            @Override
            public String getName() {

                return unknownName;
            }

            @Override
            public String getSound() {

                return unknownSound;
            }
        };
        return animal;
    }
}