package nl.multicode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EnglishToOtherTranslator {

    private static final Logger log = LogManager.getLogger(EnglishToOtherTranslator.class);
    public static final String DUTCH = "dutch";
    public static final String SWEDISH = "swedish";

    public String getTranslationFor(String theWord, String toLanguage) {

        if (theWord == null || toLanguage == null) {
            return "null word or language arguments are not allowed!";
        }
        log.info("requesting translation of {} to {}", theWord, toLanguage);


        switch (theWord) {
            case "hello":
                if (DUTCH.equals(toLanguage)) {
                    return "hallo";
                } else if (toLanguage.equals(SWEDISH)) {
                    return "hallå";
                }
                return unknowTranslationMessage(theWord);
            case "bye":
                if (DUTCH.equals(toLanguage)) {
                    return "doei";
                } else if (toLanguage.equals(SWEDISH)) {
                    return "hejdå";
                }
                return unknowTranslationMessage(theWord);
            case "cake":
                if (DUTCH.equals(toLanguage)) {
                    return "taart";
                } else if (toLanguage.equals(SWEDISH)) {
                    return "kaka";
                }
                return unknowTranslationMessage(theWord);
            case "street":
                if (DUTCH.equals(toLanguage)) {
                    return "straat";
                } else if (toLanguage.equals(SWEDISH)) {
                    return "gata";
                }
                return unknowTranslationMessage(theWord);
            default:
                return unknowTranslationMessage(theWord);
        }
    }

    private static String unknowTranslationMessage(String theWord) {

        return "unknown translation for word '" + theWord + "'";
    }
}