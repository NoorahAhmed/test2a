package nl.multicode;

import lombok.Getter;

import static nl.multicode.AnimalType.BIRD;
import static nl.multicode.AnimalType.CAECILIAN;
import static nl.multicode.AnimalType.INSECT;
import static nl.multicode.AnimalType.MAMMAL;
import static nl.multicode.AnimalType.MYTH;
import static nl.multicode.AnimalType.REPTILE;
import static nl.multicode.EaterType.CARNIVORE;
import static nl.multicode.EaterType.HERBIVORE;
import static nl.multicode.EaterType.INSECTIVORE;
import static nl.multicode.EaterType.OMNIVORE;
import static nl.multicode.EaterType.UNKNOWN;

@Getter
public enum Animal {
    DOG("dog", MAMMAL, CARNIVORE),
    KOALA("koala", MAMMAL, HERBIVORE),
    CHICKEN("chicken", BIRD, OMNIVORE),
    HAWK("hawk", BIRD, CARNIVORE),
    GECKO("gecko", REPTILE, INSECTIVORE),
    WASP("wasp", INSECT, HERBIVORE),
    TOAD("toad", CAECILIAN, INSECTIVORE),
    UNICORN("unicorn", MYTH, UNKNOWN),
    BIGFOOT("bigfoot", MYTH, UNKNOWN);

    private final String value;
    private final AnimalType animalType;
    private final EaterType eaterType;

    Animal(String value, AnimalType animalType, EaterType eaterType) {

        this.value = value;
        this.animalType = animalType;
        this.eaterType = eaterType;
    }
}
