package nl.multicode;

import nl.multicode.model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class Application {

    private static final Logger log = LogManager.getLogger(Application.class);

    public List<Person> getFilteredPersons(final List<Person> people, final int minimalAgeLimit, final String nameSubstring, int numberOfChildren) {

        if (people != null) {
            log.info("Users ti filter {}", Arrays.toString(people.toArray()));


            return people.stream()
                    .filter(p -> p.getAge() > minimalAgeLimit)
                    .filter(p -> p.getName() != null)
                    .filter(p -> p.getName().toLowerCase().contains(nameSubstring.toLowerCase()))
                    .filter(p -> p.getChildren().size() == numberOfChildren)
                    .toList();
        }
        return List.of();
    }
}