package nl.multicode.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class AnimalEnumTest {

    @ParameterizedTest
    @EnumSource(AnimalEnum.class)
    void animalFromValue(AnimalEnum animalEnum) {

        final var animal = animalEnum.getAnimal();
        final var name = animal.getName();
        assertThat(AnimalEnum.animalFromValue(name)).isEqualTo(animal);
    }
}