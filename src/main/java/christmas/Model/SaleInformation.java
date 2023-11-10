package christmas.Model;

import java.util.List;

public class SaleInformation {
    private static final int MINIMUM_TOTAL_PRICE = 10000;
    private final int visitDate;
    private final User user;

    public SaleInformation(int visitDate, User user) {
        this.visitDate = visitDate;
        this.user = user;
    }

    public BonusMenu findBonusMenu() {
        return BonusMenu.valueOf(user.calculateTotalPrice());
    }

    public String allDetailsMent() {
        String detailsMent = "";
        if (isSale()) {
            detailsMent += findDDaySaleDetailsMent();
            detailsMent += findDateSaleDetailsMent();
            detailsMent += findBonusMenu().getDetailsMent();
            return detailsMent;
        }
        detailsMent += "없음";
        return detailsMent;
    }

    private String findDDaySaleDetailsMent() {
        return D_DaySale.detailsMent(visitDate);
    }

    private String findDateSaleDetailsMent() {
        String detailsMent = "";
        for (DateSale dateSale : findDateSale()) {
            detailsMent += dateSale.getDetailsMent(user.getAllMenuAndQuantity());
        }
        return detailsMent;
    }

    private List<DateSale> findDateSale() {
        return DateSale.valueOf(visitDate);
    }

    private boolean isSale() {
        return this.user.calculateTotalPrice() >= MINIMUM_TOTAL_PRICE;
    }
}
