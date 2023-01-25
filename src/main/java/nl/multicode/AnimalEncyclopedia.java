package nl.multicode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AnimalEncyclopedia {

    private static final Logger log = LogManager.getLogger(AnimalEncyclopedia.class);
    private static final String MESSAGE = "{} is a {} and is a {}";

    public void getAnimalInfo(String animal) {

        if (animal != null) {
            log.info("requested animal is {}!", animal);
            Animal animalEnum = Animal.valueOf(animal.toUpperCase());
            log.info(MESSAGE, animalEnum.getValue(), animalEnum.getAnimalType().getValue(), animalEnum.getEaterType().getValue());

        } else {
            log.info("argument null is not allowed!");
        }
    }
}