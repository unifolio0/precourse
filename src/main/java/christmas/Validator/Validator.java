package christmas.Validator;

import static christmas.Validator.ValidatorConstant.*;

public class Validator {
    private static final int FIRST_DATE = 1;
    private static final int LAST_DATE = 31;

    public static int validateParseInteger(String input) {
        try {
            int result = Integer.parseInt(input);
            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PARSE_INT_ERROR.getMessage());
        }
    }

    public static void validateVisitDateRange(int visitDate) {
        if (visitDate < FIRST_DATE || visitDate > LAST_DATE) {
            throw new IllegalArgumentException(VISIT_DATE_RANGE_ERROR.getMessage());
        }
    }
}
