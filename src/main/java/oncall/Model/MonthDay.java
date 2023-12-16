package oncall.Model;

import oncall.Parser;
import oncall.Validator.Validator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonthDay {
    private Month month;
    private Day day;
    private Map<Integer, Map<Day, Boolean>> calendar;

    public MonthDay(String input) {
        Validator.validateLastComma(input);
        List<String> monthDay = Parser.parserSplitComma(input);
        Validator.validateMonthDayInputSize(monthDay);
        this.month = Month.valueOf(Validator.validateParseInteger(monthDay.get(0)));
        this.day = Day.getDay(monthDay.get(1));
        this.calendar = new HashMap<>();
        createCalendar();
    }

    private void createCalendar() {
        boolean start = checkHoliday(1, this.day);
        calendar.put(1, Map.of(this.day, start));
        Day nextday = this.day;
        for (int i = 2; i <= this.month.getEndDay(); i++) {
            nextday = nextday.nextDay();
            calendar.put(i, Map.of(nextday, checkHoliday(i, nextday)));
        }
    }

    public boolean checkHoliday(int date, Day day) {
        if (this.month.containHoliday(date)) {
            return true;
        }
        if (day.isHoliday()) {
            return true;
        }
        return false;
    }

    public Map<Integer, Map<Day, Boolean>> getCalendar() {
        return this.calendar;
    }

    public int getEndDay() {
        return this.month.getEndDay();
    }

    public int getMonth() {
        return this.month.getMonth();
    }
}
