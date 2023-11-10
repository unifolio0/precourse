package christmas.Model;

public class SaleInfomation {
    private static final int MINIMUM_TOTAL_PRICE = 10000;
    private final int visitDate;
    private final int totalPrice;

    public SaleInfomation(int visitDate, int totalPrice) {
        this.visitDate = visitDate;
        this.totalPrice = totalPrice;
    }

    public String bonusMenuMent() {
        return BonusMenu.valueOf(totalPrice).getMent();
    }

    private boolean isSale() {
        return this.totalPrice >= MINIMUM_TOTAL_PRICE;
    }
}
