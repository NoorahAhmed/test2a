package nl.multicode.service;

import nl.multicode.map.LineToPersonMapper;
import nl.multicode.model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvService {

    private static final Logger log = LogManager.getLogger(CsvService.class);
    private final LineToPersonMapper mapper;

    public CsvService(LineToPersonMapper mapper) {

        this.mapper = mapper;
    }

    public List<Person> readPersonsCsv(String csvFile) {


        List<Person> personList = new ArrayList<>();
        File file = new File(csvFile);
        if (file.exists()) {
            try {
                final BufferedReader br;
                try (var fr = new FileReader(file)) {
                    br = new BufferedReader(fr);
                    String line;
                    int lineCount = 0;
                    while ((line = br.readLine()) != null) {
                        if (lineCount == 0) {
                            //skip header line
                            lineCount++;
                        } else {
                            final Person person = mapper.apply(line);
                            personList.add(person);
                        }
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
