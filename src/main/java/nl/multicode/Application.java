package nl.multicode;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Application {

    private static final int[] MULTIPLIERE_ARRAY = new int[]{9, 8, 7, 6, 5, 4, 3, 2, -1};
    private static final int BSN_NUMBER_LENGTH = 9;
    private static final Logger log = LogManager.getLogger(Application.class);

    public static void main(String[] args) {

        if (args[0] != null && args[0].length() > 0) {
            final var numbersArray = args[0].split(",");
            if (numbersArray.length > 0) {
                final var resultsList = new ArrayList<String>();
                for (String number : numbersArray) {
                    boolean result;
                    int sum = 0;
                    for (int i = 0; i < BSN_NUMBER_LENGTH; i++) {
                        sum += Character.getNumericValue(number.toCharArray()[i]) * MULTIPLIERE_ARRAY[i];
                    }
                    result = (sum % 11 == 0);
                    final var validityMessage = result ? (number + " is a valid " + args[1]) : (number + " is an invalid bsn");
                    resultsList.add(validityMessage);
                }
                for (String message : resultsList) {
                    log.info(message);
                }
            }
        }
    }
}