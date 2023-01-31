package nl.multicode.model;

import java.util.Arrays;

public enum AnimalEnum {
    CAT(new Cat()),
    CHICKEN(new Chicken()),
    COW(new Cow()),
    DOG(new Dog()),
    DOLPHIN(new Dolphin()),
    DOVE(new Dove()),
    HYENA(new Hyena());

    private final Animal animal;

    AnimalEnum(Animal animal) {

        this.animal = animal;
    }

    public Animal getAnimal() {

        return animal;
    }

    public static Animal animalFromValue(String value) {

        return Arrays.stream(AnimalEnum.values())
            .filter(animalEnum -> animalEnum.animal.getName().equals(value))
            .findFirst()
            .map(animalEnum -> animalEnum.animal)
            .orElse(null);
    }
}
