package oncall.Model;

import static oncall.Validator.ValidatorConstant.*;

public enum Day {
    MON("월", false),
    TUE("화", false),
    WED("수", false),
    THU("목", false),
    FRI("금", false),
    SAT("토", true),
    SUN("일", true);

    private String dayName;
    private boolean holiday;

    Day(String dayName, boolean holiday) {
        this.dayName = dayName;
        this.holiday = holiday;
    }

    public static Day getDay(String input) {
        for (Day day : values()) {
            if (day.dayName.equals(input)) {
                return day;
            }
        }
        throw new IllegalArgumentException(VALIDATE_MONTH_START_DAY.getMessage());
    }

    public boolean isHoliday() {
        return holiday;
    }

    public Day nextDay() {
        int idx = this.ordinal();
        return values()[(idx + 1) % values().length];
    }

    public String getDayName() {
        return this.dayName;
    }
}
