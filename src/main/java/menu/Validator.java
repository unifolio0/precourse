package menu;

import java.util.List;

public class Validator {
    private static final String ERROR_MINIMUM_COACHES = "[ERROR] 코치는 최소 2명 이상 입력해야 합니다.";
    private static final String ERROR_MAXIMUM_COACHES = "[ERROR] 코치는 최대 5명 이하로 입력해야 합니다.";
    private static final String ERROR_NAME_SIZE = "[ERROR] 이름은 최소 2글자, 최대 4글자로 입력해야 합니다.";

    public static void validateCoachesSize(List<String> names) {
        validateMinimumCoaches(names);
        validateMaximumCoaches(names);
    }

    private static void validateMinimumCoaches(List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException(ERROR_MINIMUM_COACHES);
        }
    }

    private static void validateMaximumCoaches(List<String> names) {
        if (names.size() > 5) {
            throw new IllegalArgumentException(ERROR_MAXIMUM_COACHES);
        }
    }

    public static void validateCoachesName(List<String> names) {
        for (String name : names) {
            validateCoachName(name);
        }
    }

    private static void validateCoachName(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException(ERROR_NAME_SIZE);
        }
    }
}
