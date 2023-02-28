package nl.multicode.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import nl.multicode.map.LineToPersonMapper;
import nl.multicode.model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PersonCsvServiceTest {

    @Mock
    private LineToPersonMapper mapper;

    @InjectMocks
    private PersonCsvService personCsvService;

    @Test
    void readPersonsCsv() {

        when(mapper.apply(anyString())).thenReturn(mock(Person.class));

        List<Person> result = personCsvService.readPersonsCsv("src/test/resources/test.csv");

        verify(mapper, times(10)).apply(anyString());
        assertThat(result).hasSize(10);
    }
}