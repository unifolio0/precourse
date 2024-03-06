package oncall;

import java.util.List;

public class Parser {
    private static final String DELIMITER = ",";

    public static List<String> parserSplitComma(String input) {
        List<String> ret = List.of(input.split(DELIMITER));
        return ret;
    }
}
