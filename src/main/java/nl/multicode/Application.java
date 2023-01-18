package nl.multicode;

import nl.multicode.model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final Logger log = LogManager.getLogger(Application.class);

    public List<Person> getFilteredPersons(List<Person> people, int minimalAgeLimit, String nameSubstring, int numberOfChildren) {

        log.info("Users ti filter");

        if (people != null && people.size() > 0) {
            List<Person> newPeople = new ArrayList<>();
            for (Person person : people) {
                if (person.getAge() >= minimalAgeLimit &&
                        person.getName() != null &&
                        person.getName().toLowerCase().contains(nameSubstring.toLowerCase()) &&
                        person.getChildren().size() == numberOfChildren) {

                    newPeople.add(person);
                }
            }
            return newPeople;
        }
        return List.of();
    }
}