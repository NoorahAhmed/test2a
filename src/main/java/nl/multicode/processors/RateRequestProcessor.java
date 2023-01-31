package nl.multicode.processors;

import lombok.RequiredArgsConstructor;
import nl.multicode.model.request.CurrencyRateRequest;
import nl.multicode.model.request.RequestMessage;
import nl.multicode.model.response.CurrencyRateResponse;
import nl.multicode.repository.RateRepository;

@RequiredArgsConstructor
public class RateRequestProcessor implements MessageProcessor {

    private final RateRepository rateRepository;

    @Override
    public String process(RequestMessage request) {

        final var currencyRateRequestMessage = (CurrencyRateRequest) request;
        final var currency = currencyRateRequestMessage.getCurrency();
        final var rate = rateRepository.getRate(currency);

        return CurrencyRateResponse.builder()
            .currency(currency)
            .rate(rate)
            .build()
            .toString();
    }
}
