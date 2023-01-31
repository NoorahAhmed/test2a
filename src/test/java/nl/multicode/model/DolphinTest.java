package nl.multicode.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DolphinTest {

    private Animal animal;

    @BeforeEach
    public void setup() {

        animal = new Dolphin();
    }

    @Test
    void getName() {

        assertThat(animal.getName()).isEqualTo("dolphin");
    }

    @Test
    void getSound() {

        assertThat(animal.getSound()).isEqualTo("click");
    }
}