package nl.multicode.model;

public enum AnimalEnum {
    CAT(new Cat()), CHICKEN(new Chicken()), COW(new Cow()), DOG(new Dog()), DOLPHIN(new Dolphin()), DOVE(new Dove()), HYENA(new Hyena());

    private final Animal animal;

    AnimalEnum(Animal animal) {
        this.animal = animal;
    }

    public static Animal animalFromValue(String value) {
        for (AnimalEnum animalEnum : AnimalEnum.values()) {
            if (animalEnum.animal.getName().equals(value)) {
                return animalEnum.animal;
            }
        }
        return null;
    }
}
