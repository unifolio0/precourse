package christmas.Model;

import christmas.Parser;
import christmas.Validator.Validator;

public class VisitDate {
    private final int visitDate;

    public VisitDate(String userInput) {
        int parseUserInput = Parser.parseVisitDate(userInput);
        Validator.validateVisitDateRange(parseUserInput);
        this.visitDate = parseUserInput;
    }
}
