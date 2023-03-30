package business_logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidString {
    public String text;

    public ValidString() {

    }

    public ValidString(String text) {
        this.text = text;
    }

    public static boolean isStringValid(String text) throws InputException {

        if (text == null || text.isEmpty())
            throw new InputException("Bad input");
        if (!text.matches("[0-9x+\\-^\\s.]+"))
            throw new InputException("Bad input");
        return true;
    }
}