package nl.multicode;

import java.util.function.Function;
import java.util.function.IntPredicate;

public class ElevenProofMessageMapper implements Function<String, String> {

    public static final IntPredicate ELEVENPROOF_PREDICATE = number -> (number % 11 == 0);
    private static final int[] MULTIPLIER_ARRAY = new int[]{9, 8, 7, 6, 5, 4, 3, 2, -1};
    private static final int BSN_NUMBER_LENGTH = 9;

    @Override
    public String apply(String number) {

        boolean result;
        int sum = 0;
        for (int i = 0; i < BSN_NUMBER_LENGTH; i++) {
            sum += getNumericValueFromSubstring(number, i) * MULTIPLIER_ARRAY[i];
        }
        result = ELEVENPROOF_PREDICATE.test(sum);
        return result ? (number + " is a valid bsn") : (number + " is an invalid bsn");
    }

    private static int getNumericValueFromSubstring(String number, int i) {

        return Character.getNumericValue(number.toCharArray()[i]);
    }
}
