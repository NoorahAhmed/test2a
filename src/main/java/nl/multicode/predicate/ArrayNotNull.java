package nl.multicode.predicate;

import java.util.function.Predicate;

public class ArrayNotNull implements Predicate<Object[]> {

    @Override
    public boolean test(Object[] objects) {

        return objects != null;
    }
}
