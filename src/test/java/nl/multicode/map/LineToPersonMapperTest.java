package nl.multicode.map;

import nl.multicode.model.HairColor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineToPersonMapperTest {

    @Test
    void apply() {

        final var person = new LineToPersonMapper().apply("name,01-01-2000,red");
        assertThat(person.getName()).isEqualTo("name");
        assertThat(person.getBirthDate()).isEqualTo("01-01-2000");
        assertThat(person.getHairColor()).isEqualTo(HairColor.RED);
    }
}