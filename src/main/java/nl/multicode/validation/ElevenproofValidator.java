package nl.multicode.validation;

public class ElevenproofValidator {

    private static final int[] MULTIPLIERE_ARRAY = new int[]{9, 8, 7, 6, 5, 4, 3, 2, -1};
    private static final int BSN_NUMBER_LENGTH = 9;

    public static boolean isValidElevenproof(String number) {

        int sum = 0;
        for (int i = 0; i < BSN_NUMBER_LENGTH; i++) {
            sum += Character.getNumericValue(number.toCharArray()[i]) * MULTIPLIERE_ARRAY[i];
        }
        return (sum % 11 == 0);
    }
}
