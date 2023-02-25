package nl.multicode.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {

    @Test
    void testToString() {
       assertThat( new Person("Dude", "01-01-2001", HairColor.RED))
               .hasToString("Person(name=Dude, birthDate=01-01-2001, hair=RED)");
    }
}