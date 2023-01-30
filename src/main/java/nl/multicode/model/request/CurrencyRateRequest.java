package nl.multicode.model.request;

import lombok.Builder;
import lombok.Getter;
import nl.multicode.model.Currency;

@Getter
@Builder
public class CurrencyRateRequest implements RequestMessage {

    private final Currency currency;
}
