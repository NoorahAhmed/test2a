package nl.multicode;

import nl.multicode.function.BsnValidityMessageFunction;
import nl.multicode.function.SplitStringFunction;
import nl.multicode.predicate.ArrayNotEmpty;
import nl.multicode.predicate.ArrayNotNull;
import nl.multicode.predicate.StringLengthEqualBsnLength;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Application {

    private static final Logger log = LogManager.getLogger(Application.class);

    public static void main(String[] args) {

        if (new ArrayNotNull().test(args) && new ArrayNotEmpty().test(args)) {
            final var numbers = args[0];
            new SplitStringFunction().apply(numbers)
                    .filter(new StringLengthEqualBsnLength())
                    .map(new BsnValidityMessageFunction())
                    .forEach(log::info);
        }
    }
}