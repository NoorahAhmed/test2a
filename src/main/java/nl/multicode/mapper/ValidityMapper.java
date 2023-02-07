package nl.multicode.mapper;

import static nl.multicode.validation.ElevenproofValidator.isValidElevenproof;

import java.util.function.Function;

public class ValidityMapper implements Function<String, String> {

    @Override
    public String apply(String number) {

        return isValidElevenproof(number) ? (number + " is a valid bsn") : (number + " is an invalid bsn");
    }
}
