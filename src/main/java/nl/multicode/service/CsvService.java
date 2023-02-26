package nl.multicode.service;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import lombok.RequiredArgsConstructor;
import nl.multicode.model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Validated
@Service
@RequiredArgsConstructor
public class CsvService {

    private static final Logger log = LogManager.getLogger(CsvService.class);

    public List<Person> readPersonsCsv(String csvFile) {

        final var personList = new ArrayList<Person>();
        CsvToBean<Person> csvToBean = getCsvToBean(csvFile);
        Iterator<Person> personIterator = csvToBean.iterator();
        while (personIterator.hasNext()) {
            personList.add(personIterator.next());
        }

        return personList;
    }

    private static CsvToBean<Person> getCsvToBean(String csvFile) {

        CsvToBean<Person> csvToBean = new CsvToBean<>();
        try {
            csvToBean.setCsvReader(new CSVReader(new BufferedReader(new FileReader(csvFile))));
            final var mappingStrategy = new HeaderColumnNameMappingStrategy();
            mappingStrategy.setType(Person.class);
            csvToBean.setMappingStrategy(mappingStrategy);
        } catch (FileNotFoundException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
        return csvToBean;
    }
}
