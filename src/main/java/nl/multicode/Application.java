package nl.multicode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Application {

    private static final Logger log = LogManager.getLogger(Application.class);

    public static void main(String[] args) {

        System.out.println(new Application().execute("combine", "dirty", "Code"));
        System.out.println(new Application().execute("combineToUppercase", "dirty", "Code"));
        System.out.println(new Application().execute("combineToUppercase", null, "Code"));

    }

    public String execute(String command, String firstArgument, String secondArgument) {

        if (command != null && command.equals("combine")) {
            if (firstArgument != null && secondArgument != null) {
                final var message = String.format("Combined firstArgument '%s' and secondArgument '%s' and resulted in '%s'", firstArgument, secondArgument, firstArgument + secondArgument);
                System.out.println(message);
                return firstArgument + secondArgument;
            }
        } else if (command != null && command.equals("combineToUppercase")) {
            if (firstArgument != null && secondArgument != null) {
                final var combinedToUppercase = firstArgument.toUpperCase() + "_" + secondArgument.toUpperCase();
                final var message = String.format("Combined to uppercase firstArgument '%s' and secondArgument '%s' resulted in '%s'", firstArgument, secondArgument, combinedToUppercase);
                System.out.println(message);
                return combinedToUppercase;
            }
        }
        return null;
    }
}