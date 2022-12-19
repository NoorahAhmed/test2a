package nl.multicode.validate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArgumentsValidator {
    private static final Logger log = LogManager.getLogger(ArgumentsValidator.class);


    public static boolean hasMinimalNumberOfArguments(String commandArgument, String typeArgument) {
        return commandArgument != null && typeArgument != null;
    }

    public static boolean isValidValidationArguments(String commandArgument, String numberArgument) {
        return isValidationACommandArgument(commandArgument) &&
                numberArgument != null &&
                hasValidNumberArgumentLength(numberArgument);
    }

    private static boolean hasValidNumberArgumentLength(String numberArgument) {
        return numberArgument.length() == 9 || numberArgument.length() == 10;
    }

    public static boolean isValidationACommandArgument(String commandArgument) {
        return "validate".equals(commandArgument);
    }
}
