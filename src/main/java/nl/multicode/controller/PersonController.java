package nl.multicode.controller;

import lombok.RequiredArgsConstructor;
import nl.multicode.model.Person;
import nl.multicode.service.CsvService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@RequiredArgsConstructor
public class PersonController {

    private static final Logger log = LogManager.getLogger(PersonController.class);

    private final CsvService csvService;

    public List<Person> readPersonsFile(String personsCsvFile) {

        log.info("Persons CSV filename {}", personsCsvFile);
        return csvService.readPersonsCsv(personsCsvFile);
    }
}
