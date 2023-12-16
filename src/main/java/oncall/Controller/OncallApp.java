package oncall.Controller;

import oncall.Model.MonthDay;
import oncall.View.InputView;

public class OncallApp {
    public void run() {
        MonthDay monthDay = createMonthDay();
    }

    private MonthDay createMonthDay() {
        String inputMonthDay = InputView.requireMonthDay();
        MonthDay monthDay = new MonthDay(inputMonthDay);
        return monthDay;
    }
}
