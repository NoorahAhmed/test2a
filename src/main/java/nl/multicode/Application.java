package nl.multicode;

import nl.multicode.model.Animal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Application {

    private static final Logger log = LogManager.getLogger(Application.class);

    public String getAnimalSound(Animal animal) {

        if (animal == null) {
            return "null animal argument is not allowed!";
        }
        log.info("requesting sound of {}", animal.getName());
        return animal.getSound();
    }
}
