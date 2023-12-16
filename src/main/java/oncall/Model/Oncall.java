package oncall.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Oncall {
    private MonthDay monthDay;
    private Peoples dayPeoples;
    private Peoples holidayPeoples;
    private Map<Integer, Map<Day, Boolean>> calendar;
    private int dayidx, holidayidx;
    private boolean isday = false, isholiday = false;
    private String prePeople;

    public Oncall(MonthDay monthDay, Peoples dayPeoples, Peoples holidayPeoples) {
        this.monthDay = monthDay;
        this.dayPeoples = dayPeoples;
        this.holidayPeoples = holidayPeoples;
        this.calendar = this.monthDay.getCalendar();
    }

    public List<String> oncallCalendar() {
        List<String> monthCalendar = new ArrayList<>();
        String people, month = String.valueOf(this.monthDay.getMonth());
        Day today;
        this.dayidx = -1;
        this.holidayidx = -1;
        for (int i = 1; i <= this.monthDay.getEndDay(); i++) {
            today = calendar.get(i).keySet().iterator().next();
            people = findPeople(i, today);
            monthCalendar.add(month + "월 " + i + "일 " + today.getDayName() + checkPlusHoliday(i, today) + " " + people + System.lineSeparator());
            this.prePeople = people;
        }
        return monthCalendar;
    }

    private int findidx(int date, Day today) {
        if (checkHoliday(date, today)) {
            this.holidayidx++;
            if (isholiday) {
                isholiday = false;
                return this.holidayidx - 1;
            }
            return this.holidayidx;
        }
        this.dayidx++;
        if (isday) {
            isday = false;
            return this.dayidx - 1;
        }
        return this.dayidx;
    }

    private String findPeople(int date, Day today) {
        int idx = findidx(date, today);
        String people;
        if (checkHoliday(date, today)) {
            people = this.holidayPeoples.todayPeople(idx);
            if (people.equals(prePeople)) {
                isholiday = true;
                people = this.holidayPeoples.todayPeople(idx + 1);
            }
            return people;
        }
        people = this.dayPeoples.todayPeople(idx);
        if (people.equals(this.prePeople)) {
            isday = true;
            people = this.dayPeoples.todayPeople(idx + 1);
        }
        return people;
    }

    private String checkPlusHoliday(int i, Day today) {
        if (today.isHoliday()) {
            return "";
        }
        if (this.monthDay.checkHoliday(i, today)) {
            return "(휴일)";
        }
        return "";
    }

    private boolean checkHoliday(int i, Day today) {
        return this.monthDay.checkHoliday(i, today);
    }
}
