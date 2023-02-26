package nl.multicode.controller;


import jakarta.validation.ConstraintViolationException;
import nl.multicode.model.Person;
import nl.multicode.service.CsvService;
import nl.multicode.util.TestAppender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class PersonControllerTest {

    @MockBean
    private CsvService csvService;

    @Autowired
    private PersonController personController;

    @BeforeEach
    public void setup() {

        TestAppender.clear();
    }

    @AfterEach
    public void tearDown() {

        TestAppender.clear();
    }

    @Test
    void test_empty_list() {

        final var csvFile = "fakeFile.csv";
        final List<Person> personList = List.of(mock(Person.class));
        when(csvService.readPersonsCsv(csvFile)).thenReturn(personList);

        final var result = personController.readPersonsFile(csvFile);

        verify(csvService).readPersonsCsv(csvFile);
        assertThat(result).isEqualTo(personList);
    }
}