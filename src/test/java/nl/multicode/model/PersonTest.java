package nl.multicode.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testToString() {
       assertThat( new Person("Dude", 15).toString()).isEqualTo("User: [name: [Dude], age: [15]]");
    }
}