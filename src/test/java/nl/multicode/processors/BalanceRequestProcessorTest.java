package nl.multicode.processors;

import nl.multicode.model.request.BalanceRequest;
import nl.multicode.repository.WalletRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static nl.multicode.model.Currency.DOLLAR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BalanceRequestProcessorTest {

    @Mock
    private WalletRepository repository;

    @InjectMocks
    private BalanceRequestProcessor processor;

    @Test
    void process() {

        when(repository.getBalance(DOLLAR)).thenReturn(10d);
        final var response = processor.process(BalanceRequest.builder().currency(DOLLAR).build());
        assertThat(response).isEqualTo("BalanceResponse(amount=10.0, currency=DOLLAR)");
        verify(repository).getBalance(DOLLAR);
    }
}