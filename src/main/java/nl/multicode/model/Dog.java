package nl.multicode.model;

public class Dog implements Animal {

    @Override
    public String getName() {

        return "dog";
    }

    @Override
    public String getSound() {

        return "bark";
    }
}
