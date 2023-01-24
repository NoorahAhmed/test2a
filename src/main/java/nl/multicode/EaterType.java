package nl.multicode;

import lombok.Getter;

@Getter
public enum EaterType {
    CARNIVORE("carnivore"),
    HERBIVORE("herbivore"),
    OMNIVORE("omnivore"),
    INSECTIVORE("insectivore"),
    UNKNOWN("unknown");

    private final String value;

    EaterType(String value) {

        this.value = value;
    }
}
