package oncall.Model;

import java.util.List;
import static oncall.Validator.ValidatorConstant.*;

public enum Month {
    JAN(1, List.of(1)),
    FEB(2, List.of()),
    MAR(3, List.of(1)),
    APR(4, List.of()),
    MAY(5, List.of(5)),
    JUN(6, List.of(6)),
    JUL(7, List.of()),
    AUG(8, List.of(15)),
    SEP(9, List.of()),
    OCT(10, List.of(3)),
    NOV(11, List.of()),
    DEC(12, List.of(25));

    int month;
    List<Integer> holiday;

    Month(int month, List<Integer> holiday) {
        this.month = month;
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
}
