package nl.multicode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static nl.multicode.generate.ElevenProofNumberGenerator.generate;
import static nl.multicode.validate.ArgumentsValidator.*;
import static nl.multicode.validate.ElevenProofValidator.validate;

public class Application {

    private static final Logger log = LogManager.getLogger(Application.class);

    public static void main(String[] args) {
        // three possible arguments coming in!
        // "validate", "bsn", "218996755"
        // 1)command 2)type 3)number
        final var commandArgument = args[0];
        final var typeArgument = args[1];

        if (hasMinimalNumberOfArguments(commandArgument, typeArgument)) {
            if (isValidationACommandArgument(commandArgument) && isValidValidationArguments(commandArgument, args[2])) {
                validate(args, typeArgument, args[2]);
            } else if ("generate".equals(commandArgument)) {
                generate(typeArgument);
            }
        }
    }


}