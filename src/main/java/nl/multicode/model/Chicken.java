package nl.multicode.model;

public class Chicken implements Animal {

    @Override
    public String getName() {

        return "chicken";
    }

    @Override
    public String getSound() {

        return "cackle";
    }
}
