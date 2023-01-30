package nl.multicode.model.response;

import lombok.Builder;
import lombok.Getter;
import nl.multicode.model.Currency;

@Getter
@Builder
public class CurrencyRateResponse implements ResponseMessage {

    private final Double rate;
    private final Currency currency;
}
