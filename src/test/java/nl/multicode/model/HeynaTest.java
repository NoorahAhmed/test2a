package nl.multicode.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HeynaTest {

    private Animal animal;

    @BeforeEach
    public void setup() {

        animal = new Hyena();
    }

    @Test
    void getName() {

        assertThat(animal.getName()).isEqualTo("hyena");
    }

    @Test
    void getSound() {

        assertThat(animal.getSound()).isEqualTo("laugh");
    }
}