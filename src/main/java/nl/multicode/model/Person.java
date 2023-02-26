package nl.multicode.model;


public class Person {

    private final String name;

    private final String birthDate;

    private final String hairColor;

    public Person(String name, String birthDate, String hairColor) {

        if (name != null) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("name may not be null");
        }
        if (birthDate != null && !birthDate.isEmpty()) {
            this.birthDate = birthDate;
        } else {
            throw new IllegalArgumentException("birthDate may not be null");
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

    public String getHairColor() {

        return hairColor;
    }

    @Override
    public String toString() {

        return "Person(name=" + name + ", birthDate=" + birthDate + ", hair=" + hairColor + ")";
    }
}
