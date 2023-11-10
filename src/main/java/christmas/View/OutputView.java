package christmas.View;

public class OutputView {
    private static final String LINE_BREAKING = "\n";
    private static final String PRIVIEW_TITLE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU_TITLE = "<주문 메뉴>";

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage+LINE_BREAKING);
    }

    public static void printPriviewTitle(int visitDate) {
        System.out.printf(PRIVIEW_TITLE+LINE_BREAKING.repeat(2), visitDate);
    }
}
