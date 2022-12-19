package nl.multicode.common;

public class ElevenProofConstants {

    public static final String VALIDATE_COMMAND = "validate";
    public static final int BSN_NUMBER_DIGITS_LENGTH = 9;//what is numberDigitsLength? is it numberDigitsLength of number?
    public static final int BANK_NUMBER_DIGITS_LENGTH = 10;
    // Is this code complex???
    // How to measure it? Plugin
    public static final int[] BSN_MULTIPLIER_ARRAY = {9, 8, 7, 6, 5, 4, 3, 2, -1};
    public static final int[] BANK_MULTIPLIER_ARRAY = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    public static final String BSN_TYPE_ARGUMENT = "bsn";
    public static final String BANK_TYPE_ARGUMENT = "bank";
}
