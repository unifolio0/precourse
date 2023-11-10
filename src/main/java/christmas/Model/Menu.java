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

    public static Menu getMenu(String menuName) {
        for (Menu menu : values()) {
            if (menu.detailMenu.containsKey(menuName)) {
                return menu;
            }
        }
        return null;
    }

    public static boolean containMenu(String input) {
        Map<String, Integer> chategoryMenu = getDetailMenu(input);
        if (chategoryMenu != null) {
            return true;
        }
        return false;
    }

    public static int getPrice(String menuName) {
        Map<String, Integer> chategoryMenu = getDetailMenu(menuName);
        if (chategoryMenu != null) {
            return chategoryMenu.get(menuName);
        }
        return 0;
    }

    private static Map<String, Integer> getDetailMenu(String menuName) {
        Menu menu = getMenu(menuName);
        if (menu != null) {
            return menu.detailMenu;
        }
        return null;
    }
}
