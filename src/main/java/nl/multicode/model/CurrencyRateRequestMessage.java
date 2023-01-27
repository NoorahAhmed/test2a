package nl.multicode.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CurrencyRateRequestMessage {

    private final Currency currency;
}
