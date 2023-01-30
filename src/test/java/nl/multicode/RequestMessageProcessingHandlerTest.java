package nl.multicode;

import nl.multicode.model.request.BalanceRequest;
import nl.multicode.model.request.CurrencyRateRequest;
import nl.multicode.model.request.DepositRequest;
import nl.multicode.model.request.RequestMessage;
import nl.multicode.model.request.WithdrawalRequest;
import nl.multicode.model.response.BalanceResponse;
import nl.multicode.model.response.CurrencyRateResponse;
import nl.multicode.processors.BalanceRequestProcessor;
import nl.multicode.processors.DepositRequestProcessor;
import nl.multicode.processors.RateRequestProcessor;
import nl.multicode.processors.WithdrawalRequestProcessor;
import nl.multicode.util.TestAppender;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class RequestMessageProcessingHandlerTest {

    @Mock
    private BalanceRequestProcessor balanceRequestProcessor;
    @Mock
    private DepositRequestProcessor depositRequestProcessor;
    @Mock
    private WithdrawalRequestProcessor withdrawalRequestProcessor;
    @Mock
    private RateRequestProcessor rateRequestProcessor;

    @InjectMocks
    private TransactionMessageProcessingHandler handler;


    @BeforeEach
    public void setup() {

        TestAppender.clear();
    }

    @AfterEach
    public void tearDown() {

        TestAppender.clear();
    }

    @Test
    void process_withdrawal() {

        final var withdrawalRequestMessage = WithdrawalRequest.builder().build();
        final var responseMessage = mock(BalanceResponse.class);
        when(withdrawalRequestProcessor.process(withdrawalRequestMessage)).thenReturn(responseMessage);

        final var response = handler.process(withdrawalRequestMessage);

        verify(withdrawalRequestProcessor).process(withdrawalRequestMessage);
        assertThat(response).isEqualTo(responseMessage);
    }

    @Test
    void process_deposit() {

        final var depositRequestMessage = DepositRequest.builder().build();
        final var responseMessage = mock(BalanceResponse.class);
        when(depositRequestProcessor.process(depositRequestMessage)).thenReturn(responseMessage);

        final var response = handler.process(depositRequestMessage);

        verify(depositRequestProcessor).process(depositRequestMessage);
        assertThat(response).isEqualTo(responseMessage);
    }

    @Test
    void process_balance() {

        final var balanceRequestMessage = BalanceRequest.builder().build();
        final var responseMessage = mock(BalanceResponse.class);
        when(balanceRequestProcessor.process(balanceRequestMessage)).thenReturn(responseMessage);

        final var response = handler.process(balanceRequestMessage);

        verify(balanceRequestProcessor).process(balanceRequestMessage);
        assertThat(response).isEqualTo(responseMessage);
    }

    @Test
    void process_rate() {

        final var rateRequestMessage = CurrencyRateRequest.builder().build();
        final var responseMessage = mock(CurrencyRateResponse.class);
        when(rateRequestProcessor.process(rateRequestMessage)).thenReturn(responseMessage);

        final var response = handler.process(rateRequestMessage);

        verify(rateRequestProcessor).process(rateRequestMessage);
        assertThat(response).isEqualTo(responseMessage);
    }

    @Test
    void process_unknown() {

        final var rateRequestMessage = mock(RequestMessage.class);
        assertThat(handler.process(rateRequestMessage)).isNull();
        verifyNoInteractions(balanceRequestProcessor);
        verifyNoInteractions(depositRequestProcessor);
        verifyNoInteractions(withdrawalRequestProcessor);
        verifyNoInteractions(rateRequestProcessor);
    }

    @Test
    void process_null_logging() {

        assertThat(handler.process(null)).isNull();
        assertThat(TestAppender.getLogs(Level.INFO)).contains("Processing requested for message null");
    }
}