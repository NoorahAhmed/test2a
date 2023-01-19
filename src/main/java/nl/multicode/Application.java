package nl.multicode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Application {

    private static final Logger log = LogManager.getLogger(Application.class);

    public String getAnimalSound(String animal) {

        if (animal == null) {
            return "null animal argument is not allowed!";
        }
        log.info("requesting sound of {}", animal);
        switch (animal) {
            case "cat":
                return "meow";
            case "dog":
                return "bark";
            case "cow":
                return "moo";
            case "dolphin":
                return "click";
            case "dove":
                return "coo";
            case "hyena":
                return "laugh";
            case "chicken":
                return "cackle";
            default:
                return "unknown";
        }
    }
}