package christmas.Model;

import christmas.Parser;

public class DDaySale {
    private final int visitDate;

    public DDaySale(int visitDate) {
        this.visitDate = visitDate;
    }
    public int saleAmount() {
        if (visitDate <= 25) {
            return (visitDate - 1) * 100 + 1000;
        }
        return 0;
    }

    public String detailsMent() {
        if (visitDate <= 25) {
            String detailsMent = "크리스마스 디데이 할인: -" + Parser.parseNumberCommaFormat(saleAmount()) + "원\n";
            return detailsMent;
        }
        return "";
    }
}
