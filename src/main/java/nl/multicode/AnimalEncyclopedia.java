package nl.multicode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AnimalEncyclopedia {

    private static final Logger log = LogManager.getLogger(AnimalEncyclopedia.class);
    private static final String MESSAGE = "{} is a {} and is a {}";

    public void getAnimalInfo(String animal) {

        if (animal != null) {
            log.info("requested animal is {}!", animal);
            if (animal.equals("dog")) {
                log.info(MESSAGE, animal, "mamal", "carnivore");
            } else if (animal.equals("koala")) {
                log.info(MESSAGE, animal, "mamal", "herbivore");
            } else if (animal.equals("chicken")) {
                log.info(MESSAGE, animal, "bird", "omnivore");
            } else if (animal.equals("hawk")) {
                log.info(MESSAGE, animal, "bird", "carnivore");
            } else if (animal.equals("gekko")) {
                log.info(MESSAGE, animal, "reptile", "insectivore");
            } else if (animal.equals("wasp")) {
                log.info(MESSAGE, animal, "insect", "herbivore");
            } else if (animal.equals("toad")) {
                log.info(MESSAGE, animal, "caecilian", "insectivore");
            } else if (animal.equals("unicorn")) {
                log.info(MESSAGE, animal, "myth", "unknown");
            } else if (animal.equals("bigfoot")) {
                log.info(MESSAGE, animal, "myth", "unknown");
            }
        } else {
            log.info("argument null is not allowed!");
        }
    }
}