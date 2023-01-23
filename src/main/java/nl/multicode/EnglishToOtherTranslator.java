package nl.multicode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EnglishToOtherTranslator {

    private static final Logger log = LogManager.getLogger(EnglishToOtherTranslator.class);

    public String getTranslationFor(String theWord) {

        if (theWord != null) {
            log.info("requesting translation of {} to swedish", theWord);
            switch (theWord) {
                case "hello":
                    return "hallå";
                case "bye":
                    return "hejdå";
                case "hi":
                    return "hej";
                case "welcome":
                    return "välkommen";
                case "later":
                    return "senare";
                case "goodbye":
                    return "adjö";
                default:
                    return unknowTranslationMessage(theWord);
            }
        }
        return "null word or language arguments are not allowed!";
    }

    private static String unknowTranslationMessage(String theWord) {

        return "unknown translation for word '" + theWord + "'";
    }
}