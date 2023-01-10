package nl.multicode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Application {

    private static final Logger log = LogManager.getLogger(Application.class);

    public static void main(String[] args) {

        new Application().execute("combine", "dirty", "Code");
        new Application().execute("combineToUppercase", "dirty", "Code");
        new Application().execute("combineToUppercase", null, "Code");
    }

    public String execute(String command, String firstArgument, String secondArgument) {

        if (command != null && command.equals("combine")) {
            if (firstArgument != null && secondArgument != null) {
                log.info("Combined firstArgument '{}' and secondArgument '{}' and resulted in '{}'", firstArgument, secondArgument, firstArgument + secondArgument);
                return firstArgument + secondArgument;
            }
        } else if (command != null && command.equals("combineToUppercase")) {
            if (firstArgument != null && secondArgument != null) {
                final var combinedToUppercase = firstArgument.toUpperCase() + "_" + secondArgument.toUpperCase();
                log.info("Combined to uppercase firstArgument '{}' and secondArgument '{}' resulted in '{}'", firstArgument, secondArgument, combinedToUppercase);
                return combinedToUppercase;
            }
        }
        return null;
    }
}