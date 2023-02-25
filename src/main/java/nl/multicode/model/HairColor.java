package nl.multicode.model;

import java.util.Arrays;

public enum HairColor {
    BRUNETTE("brunette"),
    RED("red"),
    GRAY("gray"),
    WHITE("white"),
    BLOND("blond"),
    BLACK("black");

    private final String name;

    HairColor(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public static HairColor fromValue(String value) {

        return Arrays.stream(HairColor.values())
                .filter(hairColor -> hairColor.getName().equals(value.toLowerCase()))
                .findFirst()
                .orElse(null);
    }
}
