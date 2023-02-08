package nl.multicode.predicate;

import java.util.function.Predicate;

public class StringLengthEqualBsnLength implements Predicate<String> {

    @Override
    public boolean test(String s) {

        return s.length() == 9;
    }
}
