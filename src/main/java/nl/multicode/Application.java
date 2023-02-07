package nl.multicode;

import java.util.Arrays;
import nl.multicode.mapper.ValidityMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Application {

    private static final Logger log = LogManager.getLogger(Application.class);

    public static void main(String[] args) {

        if (args != null) {
            Arrays.stream(args)
                .map(new ValidityMapper())
                .forEach(log::info);
        }
    }
}