package oncall.Validator;

import java.util.List;

import static oncall.Validator.ValidatorConstant.*;

public class Validator {
    public static int validateParseInteger(String input) {
        try {
            int result = Integer.parseInt(input);
            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VALIDATE_MONTH_START_DAY.getMessage());
        }
    }

    public static void validateMonthDayInputSize(List<String> input) {
        if (input.size() != 2) {
            throw new IllegalArgumentException(VALIDATE_MONTH_START_DAY.getMessage());
        }
    }
}
