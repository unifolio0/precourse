package christmas.Validator;

import christmas.Model.Menu;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static christmas.Validator.ValidatorConstant.*;

public class Validator {
    private static final int FIRST_DATE = 1;
    private static final int LAST_DATE = 31;
    private  static final String MENU_AND_QUANTITY_REGULAR_EXPRESSION = "[ㄱ-ㅎㅏ-ㅣ가-힣]+-[0-9]+";

    public static int validateParseInteger(String input) {
        try {
            int result = Integer.parseInt(input);
            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VISIT_DATE_ERROR.getMessage());
        }
    }

    public static void validateVisitDateRange(int visitDate) {
        if (visitDate < FIRST_DATE || visitDate > LAST_DATE) {
            throw new IllegalArgumentException(VISIT_DATE_ERROR.getMessage());
        }
    }

    public static void validateAllMenuAndQuantityRegularExpression(List<String> userInput) {
        for (String input : userInput) {
            validateMenuAndQuantityRegularExpression(input);
        }
    }

    private static void validateMenuAndQuantityRegularExpression(String input) {
        if (!Pattern.matches(MENU_AND_QUANTITY_REGULAR_EXPRESSION, input)) {
            throw new IllegalArgumentException(MENU_AND_QUANTITY_ERROR.getMessage());
        }
    }

    public static void validateQuantitySize(int input) {
        if (input < 1) {
            throw new IllegalArgumentException(MENU_AND_QUANTITY_ERROR.getMessage());
        }
    }

    public static void validateContainMenu(String input) {
        if (!Menu.containMenu(input)) {
            throw new IllegalArgumentException(MENU_AND_QUANTITY_ERROR.getMessage());
        }
    }

    public static void validateDuplicateUserMenu(Map<String, Integer> userMenuAndQuantity, String input) {
        if (userMenuAndQuantity.containsKey(input)) {
            throw new IllegalArgumentException(MENU_AND_QUANTITY_ERROR.getMessage());
        }
    }
}
