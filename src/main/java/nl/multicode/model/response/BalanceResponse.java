package nl.multicode.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import nl.multicode.model.Currency;

@ToString
@Getter
@Builder
public class BalanceResponse implements ResponseMessage {

    private final Double amount;
    private final Currency currency;
}
