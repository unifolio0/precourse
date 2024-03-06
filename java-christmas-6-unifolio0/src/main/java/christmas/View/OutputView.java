package christmas.View;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class OutputView {
    private static final String LINE_BREAKING = "\n";
    private static final String GREETINGS = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String PRIVIEW_TITLE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU_TITLE = "<주문 메뉴>";
    private static final String ORDER_MENU_PRINT_FORMAT = "%s %d개";
    private static final String BEFORE_SALE_TOTAL_PRICE_TITLE = "<할인 전 총주문 금액>";
    private static final String BONUS_MENU_TITLE = "<증정 메뉴>";
    private static final String BENEFIT_DETAILS_TITLE = "<혜택 내역>";
    private static final String TOTAL_BENEFIT_PRICE_TITLE = "<총혜택 금액>";
    private static final String ACTUAL_PAYMENT_TITLE = "<할인 후 예상 결제 금액>";
    private static final String EVENT_BADGE_TITLE = "<12월 이벤트 배지>";
    private static final String PRICE_FORMAT = "%s원";

    public static void printGreeting() {
        System.out.println(GREETINGS);
    }
    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage+LINE_BREAKING);
    }

    public static void printPreviewTitle(int visitDate) {
        System.out.printf(PRIVIEW_TITLE+LINE_BREAKING.repeat(2), visitDate);
    }

    public static void printAllOrderMenu(Map<String, Integer> allMenuAndQuantity) {
        System.out.println(ORDER_MENU_TITLE);
        Set<Map.Entry<String, Integer>> entrySet = allMenuAndQuantity.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();
        printOrderMenu(iterator);
    }

    private static void printOrderMenu(Iterator<Map.Entry<String, Integer>> iterator) {
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.printf(ORDER_MENU_PRINT_FORMAT+LINE_BREAKING, entry.getKey(), entry.getValue());
        }
        System.out.println();
    }

    public static void printBeforeSaleTotalPrice(String totalPrice) {
        System.out.println(BEFORE_SALE_TOTAL_PRICE_TITLE);
        System.out.printf(PRICE_FORMAT+LINE_BREAKING.repeat(2), totalPrice);
    }

    public static void printBonusMenu(String ment) {
        System.out.println(BONUS_MENU_TITLE);
        System.out.println(ment + LINE_BREAKING);
    }

    public static void printBenefitDetails(String ment) {
        System.out.println(BENEFIT_DETAILS_TITLE);
        System.out.println(ment);
    }

    public static void printAllBenefitPrice(String totalBenefitPrice) {
        System.out.println(TOTAL_BENEFIT_PRICE_TITLE);
        System.out.printf(PRICE_FORMAT + LINE_BREAKING.repeat(2), totalBenefitPrice);
    }

    public static void printActualPayment(String actualPayment) {
        System.out.println(ACTUAL_PAYMENT_TITLE);
        System.out.printf(PRICE_FORMAT + LINE_BREAKING.repeat(2), actualPayment);
    }

    public static void printEventBadge(String eventBadge) {
        System.out.println(EVENT_BADGE_TITLE);
        System.out.println(eventBadge);
    }
}
