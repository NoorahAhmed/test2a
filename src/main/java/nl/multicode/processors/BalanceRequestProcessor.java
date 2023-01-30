package nl.multicode.processors;

import lombok.RequiredArgsConstructor;
import nl.multicode.model.request.BalanceRequest;
import nl.multicode.model.response.BalanceResponse;
import nl.multicode.repository.WalletRepository;

@RequiredArgsConstructor
public class BalanceRequestProcessor implements MessageProcessor {

    private final WalletRepository wallet;

    public BalanceResponse process(Object request) {

        final var balanceRequest = (BalanceRequest) request;
        final var currency = balanceRequest.getCurrency();

        return BalanceResponse.builder()
                .amount(wallet.getBalance(currency))
                .currency(currency)
                .build();
    }
}
