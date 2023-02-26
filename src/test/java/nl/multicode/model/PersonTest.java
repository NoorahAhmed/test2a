package nl.multicode.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonTest {

    @Test
    void testToString() {

        assertThat(new Person("Dude", "01-01-2001", "red"))
                .hasToString("Person(name=Dude, birthDate=01-01-2001, hair=red)");
    }

    @Test
    void testConstructorBadName() {

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new Person(null, "01-01-2001", "red");
        }, "IllegalArgumentException was expected");

        assertThat(thrown.getMessage()).isEqualTo("name may not be null");
    }

    @Test
    void testConstructorBadBirthDate() {

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new Person("name", null, "brunette");
        }, "IllegalArgumentException was expected");

        assertThat(thrown.getMessage()).isEqualTo("birthDate may not be null");
    }

    @Test
    void testConstructorBadHairColor() {

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new Person("name", "01-01-2001", null);
        }, "IllegalArgumentException was expected");

        assertThat(thrown.getMessage()).isEqualTo("hairColor may not be null");
    }
}