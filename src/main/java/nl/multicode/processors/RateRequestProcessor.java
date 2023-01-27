package nl.multicode.processors;

import lombok.RequiredArgsConstructor;
import nl.multicode.model.request.CurrencyRateRequestMessage;
import nl.multicode.model.response.CurrencyRateResponseMessage;
import nl.multicode.repository.MessageProcessor;
import nl.multicode.repository.RateRepository;

@RequiredArgsConstructor
public class RateRequestProcessor implements MessageProcessor<CurrencyRateRequestMessage, CurrencyRateResponseMessage> {

    private final RateRepository rateRepository;


    @Override
    public CurrencyRateResponseMessage process(CurrencyRateRequestMessage currencyRateRequestMessage) {

        final var currency = currencyRateRequestMessage.getCurrency();

        return CurrencyRateResponseMessage.builder()
                .currency(currency)
                .rate(rateRepository.getRate(currency))
                .build();
    }
}
