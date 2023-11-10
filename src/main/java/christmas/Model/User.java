package christmas.Model;

import christmas.Parser;
import christmas.Validator.Validator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private final Map<String, Integer> allMenuAndQuantity;
    public User(String userInput) {
        List<String> parseUserInput = Parser.parseStringSplitComma(userInput);
        Validator.validateAllMenuAndQuantityRegularExpression(parseUserInput);
        Map<String, Integer> allMenuAndQuantity = makeAllMenuAndQuantity(parseUserInput);
        this.allMenuAndQuantity = allMenuAndQuantity;
        System.out.println(allMenuAndQuantity);
    }

    private Map<String, Integer> makeAllMenuAndQuantity(List<String> userInput) {
        Map<String, Integer> userMenuAndQuantity = new HashMap<>();
        for (String input : userInput) {
            makeMenuAndQuantity(userMenuAndQuantity, input);
        }
        return userMenuAndQuantity;
    }

    private void makeMenuAndQuantity(Map<String, Integer> userMenuAndQuantity, String input) {
        List<String> parseInput = Parser.parseStringSplitHyphen(input);
        int quantity = Validator.validateParseInteger(parseInput.get(1));
        Validator.validateQuantitySize(quantity);
        Validator.validateContainMenu(parseInput.get(0));
        Validator.validateDuplicateUserMenu(userMenuAndQuantity, parseInput.get(0));
        userMenuAndQuantity.put(parseInput.get(0), quantity);
    }
}
