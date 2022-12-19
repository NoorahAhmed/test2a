package nl.multicode.validate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static nl.multicode.common.ElevenProofConstants.*;

public class ElevenProofValidator {

    private static final Logger log = LogManager.getLogger(ElevenProofValidator.class);


    public static void validate(String[] args, String typeArgument, String numberArgument) {
        if (ElevenProofValidator.validate(args)) {
            log.info(numberArgument + " is a valid " + typeArgument);
        } else {
            log.info(numberArgument + " is an invalid " + typeArgument);
        }
    }

    public static boolean validate(String[] args) {

        int[] multiplierArray;
        int numberDigitsLength;
        final var typeArgument = args[1];
        final var numberArgument = args[2];

        if (BSN_TYPE_ARGUMENT.equals(typeArgument) && numberArgument.length() == BSN_NUMBER_DIGITS_LENGTH) {
            numberDigitsLength = BSN_NUMBER_DIGITS_LENGTH;
            multiplierArray = BSN_MULTIPLIER_ARRAY;
        } else if (BANK_TYPE_ARGUMENT.equals(typeArgument) && numberArgument.length() == BANK_NUMBER_DIGITS_LENGTH) {
            numberDigitsLength = BANK_NUMBER_DIGITS_LENGTH;
            multiplierArray = BANK_MULTIPLIER_ARRAY;
        } else {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < numberDigitsLength; i++) {
            sum += Character.getNumericValue(numberArgument.toCharArray()[i]) * multiplierArray[i];
        }
        return (sum % 11 == 0);
    }
}
