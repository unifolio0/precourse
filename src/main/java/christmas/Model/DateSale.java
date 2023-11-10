package christmas.Model;

import christmas.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public enum DateSale {
    WEEKDAYS_SALE(List.of(3,4,5,6,7,10,11,12,13,14,17,18,19,20,21,24,25,26,27,28,31), "평일 할인: -") {
        public int getSaleAmount(Map<String, Integer> allMenu) {
            int total = 0;
            for (String key : allMenu.keySet()) {
                if (Menu.getMenu(key).equals(Menu.DESSERT)) {
                    total += 2023 * allMenu.get(key);
                }
            }
            return total;
        }
    },
    WEEKEND_SALE(List.of(1,2,8,9,15,16,22,23,29,30), "주말 할인: -") {
        public int getSaleAmount(Map<String, Integer> allMenu) {
            int total = 0;
            for (String key : allMenu.keySet()) {
                if (Menu.getMenu(key).equals(Menu.MAIN)) {
                    total += 2023 * allMenu.get(key);
                }
            }
            return total;
        }
    },
    SPECIAL_SALE(List.of(3,10,17,24,25,31), "특별 할인: -") {
        public int getSaleAmount(Map<String, Integer> allMenu) {
            return 1000;
        }
    };

    private List<Integer> days;
    private String detailsMent;

    DateSale(List<Integer> days, String detailsMent) {
        this.days = days;
        this.detailsMent = detailsMent;
    }

    public static List<DateSale> valueOf(int date) {
        List<DateSale> sale = new ArrayList<>();
        for (DateSale dateSale : values()) {
            if (dateSale.days.contains(date)) {
                sale.add(dateSale);
            }
        }
        return sale;
    }

    public String getDetailsMent(Map<String, Integer> allMenuAndQuantity) {
        return this.detailsMent + fomatingSaleAmount(getSaleAmount(allMenuAndQuantity)) + "원\n";
    }

    private String fomatingSaleAmount(int saleAmount) {
        return Parser.parseNumberCommaFormat(saleAmount);
    }

    public abstract int getSaleAmount(Map<String, Integer> allMenu);
}
