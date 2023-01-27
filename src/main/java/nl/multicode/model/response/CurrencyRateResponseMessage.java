package nl.multicode.model.response;

import lombok.Builder;
import lombok.Getter;
import nl.multicode.model.Currency;
import nl.multicode.model.TransactionMessage;

@Getter
@Builder
public class CurrencyRateResponseMessage implements TransactionMessage {

    private final Double rate;
    private final Currency currency;
}
