package nl.multicode.processors;

import nl.multicode.model.request.DepositRequest;
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
class DepositRequestProcessorTest {

    public static final double AMOUNT = 10d;
    @Mock
    private WalletRepository repository;

    @InjectMocks
    private DepositRequestProcessor processor;

    @Test
    void process() {

        when(repository.getBalance(DOLLAR)).thenReturn(AMOUNT);
        final var response = processor.process(DepositRequest.builder()
                .currency(DOLLAR)
                .amount(AMOUNT)
                .build());
        verify(repository).deposit(DOLLAR, AMOUNT);
        verify(repository).getBalance(DOLLAR);
        assertThat(response.getAmount()).isEqualTo(AMOUNT);
        assertThat(response.getCurrency()).isEqualTo(DOLLAR);
    }
}