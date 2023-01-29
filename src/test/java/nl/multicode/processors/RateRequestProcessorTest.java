package nl.multicode.processors;

import nl.multicode.model.Currency;
import nl.multicode.model.request.CurrencyRateRequestMessage;
import nl.multicode.repository.RateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RateRequestProcessorTest {

    @Mock
    private RateRepository repository;

    @InjectMocks
    private RateRequestProcessor processor;


    @Test
    void process() {

        final var dinarRate = 0.1d;
        when(repository.getRate(Currency.DINAR)).thenReturn(dinarRate);
        final var response = processor.process(CurrencyRateRequestMessage.builder()
                .currency(Currency.DINAR)
                .build());
        assertThat(response.getRate()).isEqualTo(dinarRate);
        verify(repository).getRate(Currency.DINAR);
    }
}