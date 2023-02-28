package nl.multicode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import nl.multicode.controller.PersonController;
import nl.multicode.model.Person;
import nl.multicode.service.PersonCsvService;
import nl.multicode.util.TestAppender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PersonControllerTest {

    @Mock
    private PersonCsvService personCsvService;

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

        final var csvFile = "fakeFile.csv";
        final List<Person> personList = List.of(mock(Person.class));
        when(personCsvService.readPersonsCsv(csvFile)).thenReturn(personList);

        final var result = personController.readPersonsFile(csvFile);

        assertThat(result).isEqualTo(personList);
        verify(personCsvService).readPersonsCsv(csvFile);
    }

    @Test
    void test_empty_string() {

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            personController.readPersonsFile("");
        }, "IllegalArgumentException was expected");
        assertThat(thrown.getMessage()).isEqualTo("csv file must not be null or empty string!");
    }
}