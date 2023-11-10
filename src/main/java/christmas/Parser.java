package christmas;

import christmas.Validator.Validator;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String DELIMITER_COMMA = ",";
    private static final String DELIMITER_HYPHEN = "-";

    public static int parseVisitDate(String input) {
        int visitDate = Validator.validateParseInteger(input);
        return visitDate;
    }

    public static List<String> parseStringSplitComma(String input) {
        List<String> parseString = Arrays.asList(input.split(DELIMITER_COMMA));
        return parseString;
    }

    public static List<String> parseStringSplitHyphen(String input) {
        List<String> parseString = Arrays.asList(input.split(DELIMITER_HYPHEN));
        return parseString;
    }

    public static String parseNumberCommaFormat(int price) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        return decimalFormat.format(price);
    }
}
