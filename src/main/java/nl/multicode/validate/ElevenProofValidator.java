package nl.multicode.validate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static nl.multicode.common.ElevenProofConstants.BANK_MULTIPLIER_ARRAY;
import static nl.multicode.common.ElevenProofConstants.BANK_NUMBER_DIGITS_LENGTH;
import static nl.multicode.common.ElevenProofConstants.BANK_TYPE_ARGUMENT;
import static nl.multicode.common.ElevenProofConstants.BSN_MULTIPLIER_ARRAY;
import static nl.multicode.common.ElevenProofConstants.BSN_NUMBER_DIGITS_LENGTH;
import static nl.multicode.common.ElevenProofConstants.BSN_TYPE_ARGUMENT;

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


        final var typeArgument = args[1];
        final var numberArgument = args[2];
        var isModuloEleven = false;

        if (BSN_TYPE_ARGUMENT.equals(typeArgument) && numberArgument.length() == BSN_NUMBER_DIGITS_LENGTH) {
            isModuloEleven = isModEleven(BSN_MULTIPLIER_ARRAY, BSN_NUMBER_DIGITS_LENGTH, numberArgument);

        } else if (BANK_TYPE_ARGUMENT.equals(typeArgument) && numberArgument.length() == BANK_NUMBER_DIGITS_LENGTH) {
            isModuloEleven = isModEleven(BANK_MULTIPLIER_ARRAY, BANK_NUMBER_DIGITS_LENGTH, numberArgument);
        }

        return isModuloEleven;
    }

    private static boolean isModEleven(int[] multiplierArray, int numberDigitsLength, String numberArgument) {
        int sum = 0;
        for (int i = 0; i < numberDigitsLength; i++) {
            sum += Character.getNumericValue(numberArgument.toCharArray()[i]) * multiplierArray[i];
        }
        return (sum % 11 == 0);
    }
}
