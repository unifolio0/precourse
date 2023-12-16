package oncall.Validator;

import java.util.Collections;
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

    public static void validatePeoplesSize(List<String> input) {
        if (input.size() < 5 || input.size() > 35) {
            throw new IllegalArgumentException(VALIDATE_PEOPLES.getMessage());
        }
    }

    public static void validatePeoplesName(List<String> input) {
        for (String people : input) {
            validatePeopleName(people);
        }
    }

    private static void validatePeopleName(String people) {
        if (people.isEmpty() || people.length() > 5) {
            throw new IllegalArgumentException(VALIDATE_PEOPLES.getMessage());
        }
    }

    public static void validateDuplicatePeople(List<String> input) {
        for (String people : input) {
            if (Collections.frequency(input, people) > 1) {
                throw new IllegalArgumentException(VALIDATE_PEOPLES.getMessage());
            }
        }
    }

    public static void validateEqualPeoples(List<String> oldPeoples, List<String> newPeoples) {
        validateEqualSize(oldPeoples, newPeoples);
        validateEqualNames(oldPeoples, newPeoples);
    }

    private static void validateEqualSize(List<String> oldPeoples, List<String> newPeoples) {
        if (oldPeoples.size() != newPeoples.size()) {
            throw new IllegalArgumentException(VALIDATE_PEOPLES.getMessage());
        }
    }

    private static void validateEqualNames(List<String> oldPeoples, List<String> newPeoples) {
        for (String name : newPeoples) {
            if (Collections.frequency(oldPeoples, name) != 1) {
                throw new IllegalArgumentException(VALIDATE_PEOPLES.getMessage());
            }
        }
    }
}
