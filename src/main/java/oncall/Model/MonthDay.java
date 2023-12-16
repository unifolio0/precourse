package oncall.Model;

import oncall.Parser;
import oncall.Validator.Validator;

import java.util.List;

public class MonthDay {
    private Month month;
    private Day day;
    public MonthDay(String input) {
        List<String> monthDay = Parser.parserSplitComma(input);
        Validator.validateMonthDayInputSize(monthDay);
        this.month = Month.valueOf(Validator.validateParseInteger(monthDay.get(0)));
        this.day = Day.getDay(monthDay.get(1));
    }
}
