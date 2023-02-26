package nl.multicode.service;

import nl.multicode.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CsvServiceTest {

    private CsvService csvService;

    @BeforeEach
    public void setup(){
        csvService = new CsvService();
    }

    @Test
    void readPersonsCsv_happyFlow() {


        List<Person> result = csvService.readPersonsCsv("src/test/resources/testHappyFlow.csv");

        assertThat(result).hasSize(10);
    }
}