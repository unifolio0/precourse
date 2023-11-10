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

    private boolean isSale() {
        return this.user.calculateTotalPrice() >= MINIMUM_TOTAL_PRICE;
    }

    private D_DaySale findDDaySale() {
        return new D_DaySale(visitDate);
    }

    private String findDDaySaleDetailsMent() {
        return findDDaySale().detailsMent();
    }

    private String findDateSaleDetailsMent() {
        String detailsMent = "";
        for (DateSale dateSale : findDateSale()) {
            detailsMent += dateSale.getDetailsMent(user.getAllMenuAndQuantity());
        }
        return detailsMent;
    }

    private int findDateSaleAmount() {
        int saleAmount = 0;
        for (DateSale dateSale : findDateSale()) {
            saleAmount += dateSale.getSaleAmount(user.getAllMenuAndQuantity());
        }
        return saleAmount;
    }

    private List<DateSale> findDateSale() {
        return DateSale.valueOf(visitDate);
    }

    public int findTotalBenefitPrice() {
        int total = 0;
        total += findBonusMenu().getPrice();
        total += findDDaySale().saleAmount();
        total += findDateSaleAmount();
        return total;
    }
}
