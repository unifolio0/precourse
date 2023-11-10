package christmas.Model;

import christmas.Parser;
import christmas.Validator.Validator;

import java.util.*;

public class User {
    private final Map<String, Integer> allMenuAndQuantity;
    //key:주문한 음식 이름, value:주문한 음식 갯수
    private final int totalPrice;
    private List<Integer> chategoryCount = new ArrayList<Integer>(List.of(0,0,0,0));
    // 각 카테고리별 주문 수를 저장한 리스트, 각 인덱스 0:APPETIZER, 1:MAIN, 2:DESSERT, 3:BEVERAGE

    public User(String userInput) {
        List<String> parseUserInput = Parser.parseStringSplitComma(userInput);
        Validator.validateAllMenuAndQuantityRegularExpression(parseUserInput);
        Map<String, Integer> allMenuAndQuantity = makeAllMenuAndQuantity(parseUserInput);
        this.allMenuAndQuantity = allMenuAndQuantity;
        this.totalPrice = calculateTotalPrice();
        Validator.validateOnlyBeverage(this.chategoryCount);
    }

    private Map<String, Integer> makeAllMenuAndQuantity(List<String> userInput) {
        Map<String, Integer> userMenuAndQuantity = new HashMap<>();
        int total = 0;
        for (String input : userInput) {
            total += makeMenuAndQuantity(userMenuAndQuantity, input);
        }
        Validator.validateTotalSize(total);
        return userMenuAndQuantity;
    }

    private int makeMenuAndQuantity(Map<String, Integer> userMenuAndQuantity, String input) {
        List<String> parseInput = Parser.parseStringSplitHyphen(input);
        int quantity = Validator.validateParseInteger(parseInput.get(1));
        Validator.validateQuantitySize(quantity);
        Validator.validateContainMenu(parseInput.get(0));
        Validator.validateDuplicateUserMenu(userMenuAndQuantity, parseInput.get(0));
        userMenuAndQuantity.put(parseInput.get(0), quantity);
        return quantity;
    }

    private int calculateTotalPrice() {
        int totalPrice = 0;
        Set<String> allMenuName = this.allMenuAndQuantity.keySet();
        calculateChategoryCount(allMenuName);
        Iterator<String> iterator = allMenuName.iterator();
        while (iterator.hasNext()) {
            String menuName = iterator.next();
            totalPrice += Menu.getPrice(menuName) * allMenuAndQuantity.get(menuName);
        }
        return totalPrice;
    }

    private void calculateChategoryCount(Set<String> allMenuName) {
        Iterator<String> iterator = allMenuName.iterator();
        while (iterator.hasNext()) {
            String menuName = iterator.next();
            int index = Menu.getMenu(menuName).ordinal();
            this.chategoryCount.set(index, chategoryCount.get(index) + 1);
        }
    }
}
