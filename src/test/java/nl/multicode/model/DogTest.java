package nl.multicode.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DogTest {

    private Animal animal;

    @BeforeEach
    public void setup() {

        animal = new Dog();
    }

    @Test
    void getName() {

        assertThat(animal.getName()).isEqualTo("dog");
    }

    @Test
    void getSound() {

        assertThat(animal.getSound()).isEqualTo("bark");
    }
}