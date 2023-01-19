package nl.multicode.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChickenTest {

    private Animal animal;

    @BeforeEach
    public void setup() {

        animal = new Chicken();
    }

    @Test
    void getName() {

        assertThat(animal.getName()).isEqualTo("chicken");
    }

    @Test
    void getSound() {

        assertThat(animal.getSound()).isEqualTo("cackle");
    }
}