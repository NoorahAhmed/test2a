package nl.multicode.model;

public class Cat implements Animal {

    @Override
    public String getName() {

        return "cat";
    }

    @Override
    public String getSound() {

        return "meow";
    }
}
