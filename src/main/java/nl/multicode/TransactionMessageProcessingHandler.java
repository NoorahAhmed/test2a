package nl.multicode;

import lombok.RequiredArgsConstructor;
import nl.multicode.model.request.BalanceRequest;
import nl.multicode.model.request.CurrencyRateRequest;
import nl.multicode.model.request.DepositRequest;
import nl.multicode.model.request.RequestMessage;
import nl.multicode.model.request.WithdrawalRequest;
import nl.multicode.model.response.ResponseMessage;
import nl.multicode.processors.BalanceRequestProcessor;
import nl.multicode.processors.DepositRequestProcessor;
import nl.multicode.processors.RateRequestProcessor;
import nl.multicode.processors.WithdrawalRequestProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@RequiredArgsConstructor
public class TransactionMessageProcessingHandler {

    private static final Logger log = LogManager.getLogger(TransactionMessageProcessingHandler.class);
    private final BalanceRequestProcessor balanceRequestProcessor;
    private final DepositRequestProcessor depositRequestProcessor;
    private final WithdrawalRequestProcessor withdrawalRequestProcessor;
    private final RateRequestProcessor rateRequestProcessor;

    public ResponseMessage process(RequestMessage message) {

        log.info("Processing requested for message {}", message);
        if(message!=null) {
            if (message instanceof BalanceRequest balanceRequestMessage) {
                return balanceRequestProcessor.process(balanceRequestMessage);
            }
            if (message instanceof WithdrawalRequest withdrawalRequestMessage) {
                return withdrawalRequestProcessor.process(withdrawalRequestMessage);
            }
            if (message instanceof DepositRequest depositRequestMessage) {
                return depositRequestProcessor.process(depositRequestMessage);
            }
            if (message instanceof CurrencyRateRequest currencyRateRequestMessage) {
                return rateRequestProcessor.process(currencyRateRequestMessage);
            }
        }
        return null;
    }
}