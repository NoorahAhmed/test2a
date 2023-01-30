package nl.multicode.model.request;

import lombok.Builder;
import lombok.Getter;
import nl.multicode.model.Currency;

@Getter
@Builder
public class DepositRequest implements RequestMessage {

    private final double amount;
    private final Currency currency;
}
