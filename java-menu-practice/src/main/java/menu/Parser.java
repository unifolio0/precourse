package menu;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String DELIMITER = ",";

    public static List<String> parserSplitComma(String input) {
        List<String> parseString = Arrays.asList(input.split(DELIMITER));
        return parseString;
    }
}
