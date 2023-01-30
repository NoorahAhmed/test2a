package nl.multicode;

import nl.multicode.model.request.BalanceRequest;
import nl.multicode.model.request.CurrencyRateRequest;
import nl.multicode.model.request.DepositRequest;
import nl.multicode.model.request.RequestMessage;
import nl.multicode.model.request.WithdrawalRequest;
import nl.multicode.processors.BalanceRequestProcessor;
import nl.multicode.processors.DepositRequestProcessor;
import nl.multicode.processors.MessageProcessor;
import nl.multicode.processors.RateRequestProcessor;
import nl.multicode.processors.WithdrawalRequestProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

import static java.util.Map.entry;


public class TransactionMessageProcessingHandler {

    private static final Logger log = LogManager.getLogger(TransactionMessageProcessingHandler.class);

    private final Map<String, MessageProcessor> messageProcessors;

    public TransactionMessageProcessingHandler(final BalanceRequestProcessor balanceRequestProcessor,
                                               final DepositRequestProcessor depositRequestProcessor,
                                               final WithdrawalRequestProcessor withdrawalRequestProcessor,
                                               final RateRequestProcessor rateRequestProcessor) {

        this.messageProcessors = Map.ofEntries(
                entry(getClassName(BalanceRequest.class), balanceRequestProcessor),
                entry(getClassName(WithdrawalRequest.class), withdrawalRequestProcessor),
                entry(getClassName(DepositRequest.class), depositRequestProcessor),
                entry(getClassName(CurrencyRateRequest.class), rateRequestProcessor));
    }


    public Object process(RequestMessage message) {

        log.info("Processing requested for message {}", message);
        final var messageProcessor = this.messageProcessors.get(getClassName(message.getClass()));
        return messageProcessor != null ? messageProcessor.process(message) : null;
    }

    private String getClassName(Class<?> classObject) {

        return classObject.getCanonicalName();
    }
}