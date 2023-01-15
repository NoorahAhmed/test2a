package nl.multicode.model;

public class Cow implements Animal {

    @Override
    public String getName() {

        return "cow";
    }

    @Override
    public String getSound() {

        return "moo";
    }
}
