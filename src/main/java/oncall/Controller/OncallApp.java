package oncall.Controller;

import oncall.Model.MonthDay;
import oncall.Model.Peoples;
import oncall.View.InputView;
import oncall.View.OutputView;

public class OncallApp {
    private MonthDay monthDay;
    private Peoples dayPeoples;
    private Peoples holidayPeoples;

    public void run() {
        this.monthDay = createMonthDay();
        createAllPeoples();
    }

    private MonthDay createMonthDay() {
        while (true) {
            try {
                String inputMonthDay = InputView.requireMonthDay();
                MonthDay monthDay = new MonthDay(inputMonthDay);
                return monthDay;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void createAllPeoples() {
        while (true) {
            try {
                this.dayPeoples = createDayPeople();
                this.holidayPeoples = createHolidayPeople();
                return;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Peoples createDayPeople() {
        String inputDayPeoples = InputView.requireDayPeople();
        Peoples peoples = new Peoples(inputDayPeoples);
        return peoples;
    }

    private Peoples createHolidayPeople() {
        String inputDayPeoples = InputView.requireHolidayPeople();
        Peoples peoples = new Peoples(inputDayPeoples);
        this.dayPeoples.checkPeoples(peoples);
        return peoples;
    }
}
