package nl.multicode.repository;

import nl.multicode.model.Currency;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RateRepositoryTest {

    @Mock
    private Map<Currency, Double> exchangeRates;

    @InjectMocks
    private RateRepository repository;

    @Test
    void getRate() {

        when(exchangeRates.get(Currency.EURO)).thenReturn(1d);
        assertThat(repository.getRate(Currency.EURO)).isEqualTo(1d);
        verify(exchangeRates).get(Currency.EURO);
    }

    @Test
    void testGetRate() {

        repository.putRate(Currency.DINAR, 10d);
        verify(exchangeRates).put(Currency.DINAR, 10d);
    }
}