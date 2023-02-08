package nl.multicode.predicate;

import java.util.function.Predicate;

public class IntDividableByEleven implements Predicate<Integer> {

    @Override
    public boolean test(Integer integer) {

        return integer % 11 == 0;
    }
}
