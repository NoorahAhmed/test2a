package nl.multicode;


import nl.multicode.model.Animal;
import nl.multicode.model.Cat;
import nl.multicode.model.Chicken;
import nl.multicode.model.Cow;
import nl.multicode.model.Dog;
import nl.multicode.model.Dolphin;
import nl.multicode.model.Dove;
import nl.multicode.model.Hyena;
import nl.multicode.util.TestAppender;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
    void cat() {

        assertThat(application.getAnimalSound(new Cat())).isEqualTo("meow");
    }

    @Test
    void dog() {

        assertThat(application.getAnimalSound(new Dog())).isEqualTo("bark");
    }

    @Test
    void dolphin() {

        assertThat(application.getAnimalSound(new Dolphin())).isEqualTo("click");
    }

    @Test
    void cow() {

        assertThat(application.getAnimalSound(new Cow())).isEqualTo("moo");
    }

    @Test
    void hyena() {

        assertThat(application.getAnimalSound(new Hyena())).isEqualTo("laugh");
    }

    @Test
    void dove() {

        assertThat(application.getAnimalSound(new Dove())).isEqualTo("coo");
    }

    @Test
    void chicken() {

        assertThat(application.getAnimalSound(new Chicken())).isEqualTo("cackle");
    }

    @Test
    void logging() {

        Animal animal = new Animal() {
            @Override
            public String getName() {

                return "unknown";
            }

            @Override
            public String getSound() {

                return "unknown";
            }
        };
        application.getAnimalSound(animal);
        assertThat(TestAppender.getLogs(Level.INFO).get(0)).isEqualTo("requesting sound of unknown");
    }
}