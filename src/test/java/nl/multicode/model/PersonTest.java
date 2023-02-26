package nl.multicode.model;


import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testToString() {

        assertThat(new Person("Dude", "01-01-2001", "RED"))
                .hasToString("Person(name=Dude, birthDate=01-01-2001, hairColor=RED)");
    }

    @Test
    void testConstructorBadName() {

        final var person = new Person(null, "01-01-2001", "RED");

        final var violations = validator.validate(person);

        String message = violations.stream().toList().get(0).getMessage();
        assertThat(message).isEqualTo("name may not be empty");
    }

    @Test
    void testConstructorBadBirthdDte() {

        final var person = new Person("name", "41-01-1001", "RED");

        final var violations = validator.validate(person);

        String message = violations.stream().toList().get(0).getMessage();
        assertThat(message).isEqualTo("date must be valid and have dd-mm-yyyy format");
    }

    @Test
    void testConstructorBadHairColor() {

        final var person = new Person("name", "01-01-2001", null);

        final var violations = validator.validate(person);

        String message = violations.stream().toList().get(0).getMessage();
        assertThat(message).isEqualTo("hairColor may not be empty");
    }
}