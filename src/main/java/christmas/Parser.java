package christmas;

import christmas.Validator.Validator;

public class Parser {
    public static int parseVisitDate(String input) {
        int visitDate = Validator.validateParseInteger(input);
        return visitDate;
    }
}
