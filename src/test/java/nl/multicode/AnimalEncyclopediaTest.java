package nl.multicode;

import nl.multicode.util.TestAppender;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class AnimalEncyclopediaTest {

    private AnimalEncyclopedia animalEncyclopedia;

    @BeforeEach
    public void setup() {

        animalEncyclopedia = new AnimalEncyclopedia();
        TestAppender.clear();
    }

    @AfterEach
    public void tearDown() {

        TestAppender.clear();
    }

    @Test
    void null_input() {

        animalEncyclopedia.getAnimalInfo(null);
        assertThat(TestAppender.getLogs(Level.INFO)).contains("argument null is not allowed!");
    }

    @ParameterizedTest
    @CsvSource({"dog,mammal,carnivore",
            "koala,mammal,herbivore",
            "chicken,bird,omnivore",
            "hawk,bird,carnivore",
            "gecko,reptile,insectivore",
            "wasp,insect,herbivore",
            "toad,caecilian,insectivore",
            "unicorn,myth,unknown",
            "bigfoot,myth,unknown"})
    void animals(String animal, String animalType, String eaterType) {

        animalEncyclopedia.getAnimalInfo(animal);
        assertThat(TestAppender.getLogs(Level.INFO).get(1))
                .isEqualTo(animal + " is a " + animalType + " and is a " + eaterType);
    }
}