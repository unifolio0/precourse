package christmas.Model;

import christmas.Parser;

public class D_DaySale {
    private final int visitDate;

    public D_DaySale(int visitDate) {
        this.visitDate = visitDate;
    }
    public int saleAmount() {
        if (visitDate <= 25) {
            return (visitDate - 1) * 100 + 1000;
        }
        return 0;
    }

    public String detailsMent() {
        String detailsMent = "크리스마스 디데이 할인: -" + Parser.parseNumberCommaFormat(saleAmount()) + "원\n";
        return detailsMent;
    }
}
