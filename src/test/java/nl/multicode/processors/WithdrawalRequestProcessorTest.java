package nl.multicode.processors;

import nl.multicode.model.request.WithdrawalRequest;
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
class WithdrawalRequestProcessorTest {

    @Mock
    private WalletRepository repository;

    @InjectMocks
    private WithdrawalRequestProcessor processor;


    @Test
    void process() {


        final var amount = 10d;
        final var balanceAfterWithdrawal = 3d;
        when(repository.getBalance(DOLLAR)).thenReturn(balanceAfterWithdrawal);
        final var response = processor.process(WithdrawalRequest.builder()
                .currency(DOLLAR)
                .amount(amount)
                .build());
        verify(repository).withdraw(DOLLAR, amount);
        verify(repository).getBalance(DOLLAR);
        assertThat(response.getAmount()).isEqualTo(balanceAfterWithdrawal);
        assertThat(response.getCurrency()).isEqualTo(DOLLAR);
    }
}