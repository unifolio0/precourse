package oncall.Controller;

import oncall.Model.MonthDay;
import oncall.Model.Oncall;
import oncall.Model.Peoples;
import oncall.View.InputView;
import oncall.View.OutputView;

import java.util.List;

public class OncallApp {
    private MonthDay monthDay;
    private Peoples dayPeoples;
    private Peoples holidayPeoples;

    public void run() {
        this.monthDay = createMonthDay();
        createAllPeoples();
        Oncall oncall = new Oncall(this.monthDay, this.dayPeoples, this.holidayPeoples);
        List<String> calendar = oncall.oncallCalendar();
        OutputView.printCalendar(calendar);
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
