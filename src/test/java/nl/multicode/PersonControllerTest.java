package nl.multicode;


import nl.multicode.controller.PersonController;
import nl.multicode.model.Person;
import nl.multicode.service.CsvService;
import nl.multicode.util.TestAppender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class PersonControllerTest {

    @Mock
    private CsvService csvService;

    @InjectMocks
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

        final var csvFile = "test.csv";
        final List<Person> emptyList = List.of();
        when(csvService.readPersonsCsv(csvFile)).thenReturn(emptyList);

        final var result = personController.readPersonsFile(csvFile);

        assertThat(result).isEqualTo(emptyList);
        verify(csvService).readPersonsCsv(csvFile);
    }
}