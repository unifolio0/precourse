package christmas.Model;

import java.util.Map;

public enum Menu {
    APPETIZER(Map.of("양송이수프", 6000, "타파스", 5500, "시저샐러드", 8000)),
    MAIN(Map.of("티본스테이크", 55000, "바비큐립", 54000, "해산물파스타", 35000, "크리스마스파스타", 25000)),
    DESSERT(Map.of("초코케이크", 15000, "아이스크림", 5000)),
    BEVERAGE(Map.of("제로콜라", 3000, "레드와인", 60000, "샴페인", 25000));

    private Map<String, Integer> detailMenu;
    Menu(Map<String, Integer> menu) {
        this.detailMenu = menu;
    }

    public Map<String, Integer> getMenu() {
        return detailMenu;
    }

    public static boolean containMenu(String input) {
        for (Menu menu : values()) {
            if (menu.detailMenu.containsKey(input)) {
                return true;
            }
        }
        return false;
    }
}
