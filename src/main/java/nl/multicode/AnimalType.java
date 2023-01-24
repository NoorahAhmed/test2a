package nl.multicode;

import lombok.Getter;

@Getter
public enum AnimalType {
    MAMMAL("mammal"), BIRD("bird"), REPTILE("reptile"), CAECILIAN("caecilian"), INSECT("insect"), MYTH("myth");

    private final String value;

    AnimalType(String value) {

        this.value = value;
    }
}
