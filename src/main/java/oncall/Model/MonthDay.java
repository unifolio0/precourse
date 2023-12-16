package oncall.Model;

import oncall.Parser;
import oncall.Validator.Validator;

import java.util.List;

public class MonthDay {
    Month month;
    Day day;
    public MonthDay(String input) {
        List<String> monthDay = Parser.parserSplitComma(input);
        Validator.validateMonthDayInputSize(monthDay);
        this.month = Month.valueOf(Validator.validateParseInteger(input));
        this.day = Day.getDay(monthDay.get(1));
    }
}
