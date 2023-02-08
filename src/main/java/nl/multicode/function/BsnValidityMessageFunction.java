package nl.multicode.function;

import nl.multicode.predicate.IntDividableByEleven;

import java.util.function.Function;
import java.util.stream.IntStream;

public class BsnValidityMessageFunction implements Function<String, String> {

    private static final int[] MULTIPLIERE_ARRAY = new int[]{9, 8, 7, 6, 5, 4, 3, 2, -1};

    @Override
    public String apply(String number) {

        int sum = IntStream.range(0, 9)
                .map(index -> getNumericValueAtIndex(number, index) * MULTIPLIERE_ARRAY[index])
                .sum();
        return new IntDividableByEleven().test(sum) ? (number + " is a valid bsn") : (number + " is an invalid bsn");

    }

    private static int getNumericValueAtIndex(String number, int index) {

        return Character.getNumericValue(number.toCharArray()[index]);
    }
}
