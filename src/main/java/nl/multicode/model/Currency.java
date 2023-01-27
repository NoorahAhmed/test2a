package nl.multicode.model;

import lombok.Getter;

@Getter
public enum Currency {

    EURO(1.0d), DOLLAR(0.95d), KRONA(0.1d), DINAR(0.25d);

    private final double rate;

    Currency(double rate) {

        this.rate = rate;
    }
}
