package nl.multicode.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DoveTest {

    private Animal animal;

    @BeforeEach
    public void setup() {

        animal = new Dove();
    }

    @Test
    void getName() {

        assertThat(animal.getName()).isEqualTo("dove");
    }

    @Test
    void getSound() {

        assertThat(animal.getSound()).isEqualTo("coo");
    }
}