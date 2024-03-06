package christmas.Model;

public enum BonusMenu {
    NOTHING(0, "없음", ""),
    BONUS_MENU(25000, "샴페인 1개", "증정 이벤트: -25,000원\n");

    private static final int MINIMUM_BONUS_MENU_PRICE = 120000;

    private int price;
    private String ment;
    private String detailsMent;

    BonusMenu(int price, String ment, String detailsMent) {
        this.price = price;
        this.ment = ment;
        this.detailsMent = detailsMent;
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

    public String getDetailsMent() {
        return this.detailsMent;
    }
}
