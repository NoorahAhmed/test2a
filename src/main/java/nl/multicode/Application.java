package nl.multicode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

public class Application {

    public static final Predicate<String> STRING_LENGTH_PREDICATE = string -> string.length() > 0;
    public static final Predicate<String> BSN_LENGTH_PREDICATE = string -> string.length() == 9;
    public static final Predicate<Object> OBJECT_NOT_NULL_PREDICATE = Objects::nonNull;

    private static final Logger log = LogManager.getLogger(Application.class);

    public static void main(String[] args) {

        if (OBJECT_NOT_NULL_PREDICATE.test(args)) {
            Arrays.stream(args[0].split(","))
                    .filter(STRING_LENGTH_PREDICATE)
                    .filter(BSN_LENGTH_PREDICATE)
                    .map(new ElevenProofMessageMapper())
                    .forEach(log::info);
        }
    }
}