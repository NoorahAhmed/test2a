package nl.multicode;

import nl.multicode.controller.PersonController;
import nl.multicode.map.LineToPersonMapper;
import nl.multicode.service.CsvService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

public class Application {

    private static final Logger log = LogManager.getLogger(Application.class);

    public static void main(String[] args) {

        log.info("Application start: ----------- :");
        if (args.length > 0) {
            final var csvFile = args[0];
            log.info("execute reading: {}} :", csvFile);
            final var personList = new PersonController(new CsvService(new LineToPersonMapper())).readPersonsFile(csvFile);
            final var allPersonsFromFile = personList.stream().map(p -> p.toString() + "\n").collect(Collectors.joining());
            log.info("Persons from file: {}", allPersonsFromFile);
        } else {
            log.info("No csv file provided to read!");
        }
        log.info("Application finish: ----------- :");
    }

}
