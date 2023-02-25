package nl.multicode.service;

import nl.multicode.model.HairColor;
import nl.multicode.model.Person;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvService {

    public List<Person> readPersonsCsv(String csvFile) {


        List<Person> personList = new ArrayList<>();
        if (csvFile != null) {

            File file = new File(csvFile);
            if(file.exists()){
                try {
                    final BufferedReader br;
                    try (var fr = new FileReader(file)) {
                        br = new BufferedReader(fr);
                        String line;
                        while ((line = br.readLine()) != null) {
                            final var personProperties = line.split(",");
                            final var name = personProperties[0];
                            final var birthDate = personProperties[1];
                            final var hairColor = HairColor.fromValue(personProperties[2]);
                            personList.add(new Person(name, birthDate, hairColor));
                        }
                    }
                    br.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
        return personList;
    }
}
