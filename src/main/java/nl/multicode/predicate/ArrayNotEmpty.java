package nl.multicode.predicate;

import java.util.function.Predicate;

public class ArrayNotEmpty implements Predicate<Object[]> {

    @Override
    public boolean test(Object[] objects) {

        return objects.length > 0;
    }
}
