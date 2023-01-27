package nl.multicode.model.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import nl.multicode.model.Currency;
import nl.multicode.model.TransactionMessage;

@Getter
@RequiredArgsConstructor
public class CurrencyRateRequestMessage implements TransactionMessage {

    private final Currency currency;
}
