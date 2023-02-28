package nl.multicode.controller;

import java.util.List;
import nl.multicode.model.Person;
import nl.multicode.service.PersonCsvService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PersonController {

    private static final Logger log = LogManager.getLogger(PersonController.class);

    private final PersonCsvService personCsvService;

    public PersonController(final PersonCsvService personCsvService) {

        this.personCsvService = personCsvService;
    }

    public List<Person> readPersonsFile(String personsCsvFile) {

        log.info("Persons CSV filename {}", personsCsvFile);
        if (personsCsvFile != null && personsCsvFile.length() > 0) {
            return personCsvService.readPersonsCsv(personsCsvFile);
        } else {
            throw new IllegalArgumentException("csv file must not be null or empty string!");
        }
    }
}
