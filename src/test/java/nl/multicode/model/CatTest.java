package nl.multicode.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CatTest {

    private Animal animal;

    @BeforeEach
    public void setup() {

        animal = new Cat();
    }

    @Test
    void getName() {

        assertThat(animal.getName()).isEqualTo("cat");
    }

    @Test
    void getSound() {

        assertThat(animal.getSound()).isEqualTo("meow");
    }
}