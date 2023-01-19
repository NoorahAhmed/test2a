package nl.multicode.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CowTest {

    private Animal animal;

    @BeforeEach
    public void setup() {

        animal = new Cow();
    }

    @Test
    void getName() {

        assertThat(animal.getName()).isEqualTo("cow");
    }

    @Test
    void getSound() {

        assertThat(animal.getSound()).isEqualTo("moo");
    }
}