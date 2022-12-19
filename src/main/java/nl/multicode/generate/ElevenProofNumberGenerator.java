package nl.multicode.generate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static nl.multicode.common.ElevenProofConstants.*;
import static nl.multicode.validate.ElevenProofValidator.validate;

public class ElevenProofNumberGenerator {

    private static final Logger log = LogManager.getLogger(ElevenProofNumberGenerator.class);

    public static void generate(String typeArgument) {
        if ("bsn".equals(typeArgument)) {
            generateRandomElevenProofNumber(BSN_NUMBER_DIGITS_LENGTH, typeArgument);
        } else if ("bank".equals(typeArgument)) {
            generateRandomElevenProofNumber(BANK_NUMBER_DIGITS_LENGTH, typeArgument);
        }
    }

    private static void generateRandomElevenProofNumber(final int numberDigitsLength, final String typeArgument) {
        while (true) {
            final var generatedNumberBuilder = new StringBuilder();

            for (int numberIndex = 0; numberIndex < numberDigitsLength; numberIndex++) {
                generatedNumberBuilder.append((int) Math.floor(Math.random() * 10));
            }
            final var randomNumber = generatedNumberBuilder.toString();
            if (validate(new String[]{VALIDATE_COMMAND, typeArgument, randomNumber})) {
                log.info("generated :{}", randomNumber);
                break;
            }
        }
    }
}
