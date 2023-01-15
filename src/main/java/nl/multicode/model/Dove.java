package nl.multicode.model;

public class Dove implements Animal {

    @Override
    public String getName() {

        return "dove";
    }

    @Override
    public String getSound() {

        return "coo";
    }
}
