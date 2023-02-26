package nl.multicode.map;

import nl.multicode.model.Person;

import java.util.function.Function;

public class LineToPersonMapper implements Function<String, Person> {

    @Override
    public Person apply(String line) {

        final var personProperties = line.split(",");
        final var name = personProperties[0];
        final var birthDate = personProperties[1];
        final var hairColor = personProperties[2];
        return new Person(name, birthDate, hairColor);
    }
}
