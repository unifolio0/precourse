package oncall.Model;

import java.util.List;
import static oncall.Validator.ValidatorConstant.*;

public enum Month {
    JAN(1, 31, List.of(1)),
    FEB(2, 28, List.of()),
    MAR(3, 31, List.of(1)),
    APR(4, 30, List.of()),
    MAY(5, 31, List.of(5)),
    JUN(6, 30, List.of(6)),
    JUL(7, 31, List.of()),
    AUG(8, 31, List.of(15)),
    SEP(9, 30, List.of()),
    OCT(10, 31, List.of(3)),
    NOV(11, 30, List.of()),
    DEC(12, 31, List.of(25));

    private int month;
    private int endDay;
    private List<Integer> holiday;

    Month(int month, int endDay, List<Integer> holiday) {
        this.month = month;
        this.endDay = endDay;
        this.holiday = holiday;
    }

    public static Month valueOf(int input) {
        for (Month month : values()) {
            if (month.month == input) {
                return month;
            }
        }
        throw new IllegalArgumentException(VALIDATE_MONTH_START_DAY.getMessage());
    }

    public int getEndDay() {
        return this.endDay;
    }
}
