package nl.multicode.model;

import lombok.val;

public enum TranslationLanguage {
    DUTCH("dutch"), SWEDISH("swedish");

    private final String value;

    TranslationLanguage(String value) {

        this.value = value;
    }
}
