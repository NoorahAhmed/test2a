package nl.multicode.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import nl.multicode.model.Currency;

@ToString
@Getter
@Builder
public class CurrencyRateResponse implements ResponseMessage {

    private final Double rate;
    private final Currency currency;
}
