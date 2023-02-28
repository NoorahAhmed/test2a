package nl.multicode.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import nl.multicode.map.LineToPersonMapper;
import nl.multicode.model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PersonCsvService {

    private static final Logger log = LogManager.getLogger(PersonCsvService.class);
    private final LineToPersonMapper mapper;

    public PersonCsvService(LineToPersonMapper mapper) {

        this.mapper = mapper;
    }

    public List<Person> readPersonsCsv(String csvFile) {

        final var personList = new ArrayList<Person>();
        File file = new File(csvFile);
        if (file.exists()) {
            try {
                final BufferedReader br;
                try (var fr = new FileReader(file)) {
                    br = new BufferedReader(fr);
                    String line;
                    int lineCount = 0;
                    while ((line = br.readLine()) != null) {
                        if (lineCount > 0) {
                            //MAP ONLY AFTER SKIPPING FIRST LINE
                            final Person person = mapper.apply(line);
                            personList.add(person);
                        }
                        lineCount++;
                    }
                }
                br.close();
            } catch (IOException ioe) {
                log.error(ioe.getMessage());
            }
        }
        return personList;
    }
}
