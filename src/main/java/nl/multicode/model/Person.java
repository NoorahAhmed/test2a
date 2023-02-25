package nl.multicode.model;


public class Person {

    private final String name;
    private final String birthDate;

    private final HairColor hairColor;

    public Person(String name, String birthDate, HairColor hairColor) {

        if (name != null) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("name may not be null");
        }
        if (birthDate != null && !birthDate.isEmpty()) {
            this.birthDate = birthDate;
        } else {
            throw new IllegalArgumentException("age may not be less than 0");
        }
        if (hairColor != null) {
            this.hairColor = hairColor;
        } else {
            throw new IllegalArgumentException("hairColor may not be null");
        }
    }

    public String getName() {

        return name;
    }

    public String getBirthDate() {

        return birthDate;
    }

    public HairColor getHairColor() {

        return hairColor;
    }

    @Override
    public String toString() {

        return "Person(name=" + name + ", birthDate=" + birthDate + ", hair=" + hairColor + ")";
    }
}
