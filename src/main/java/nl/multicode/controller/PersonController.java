package nl.multicode.controller;

import nl.multicode.model.Person;
import nl.multicode.service.CsvService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class PersonController {

    private static final Logger log = LogManager.getLogger(PersonController.class);

    private final CsvService csvService;

    public PersonController(final CsvService csvService) {

        this.csvService = csvService;
    }

    public List<Person> readPersonsFile(String personsCsvFile) {

        log.info("Persons CSV filename {}", personsCsvFile);
        if (personsCsvFile != null && personsCsvFile.length() > 0) {
            return csvService.readPersonsCsv(personsCsvFile);
        } else {
            throw new IllegalArgumentException("csv file must not be null or empty string!");
        }
    }
}
