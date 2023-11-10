package christmas.Model;

public enum BonusMenu {
    NOTHING(0, "없음"),
    BONUS_MENU(25000, "샴페인 1개");

    private static final int MINIMUM_BONUS_MENU_PRICE = 120000;

    private int price;
    private String ment;

    BonusMenu(int price, String ment) {
        this.price = price;
        this.ment = ment;
    }

    public static BonusMenu valueOf(int totalPrice) {
        if (totalPrice >= MINIMUM_BONUS_MENU_PRICE) {
            return BONUS_MENU;
        }
        return NOTHING;
    }

    public int getPrice() {
        return this.price;
    }

    public String getMent() {
        return this.ment;
    }
}
