package nl.multicode.model;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum HelloByeSynonym {
    HELLO("hello"), HI("hi"), BYE("bye"), WELCOME("value");

    private final String value;

    HelloByeSynonym(String value) {

        this.value = value;
    }

    public static HelloByeSynonym fromValue(String value) {

        return Arrays.stream(HelloByeSynonym.values())
                .filter(synonym -> synonym.getValue().equals(value))
                .findFirst()
                .orElse(null);
    }
}
