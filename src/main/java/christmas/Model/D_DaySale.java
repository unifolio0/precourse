package christmas.Model;

import christmas.Parser;

public class D_DaySale {
    public static int saleAmount(int visitDate) {
        if (visitDate <= 25) {
            return (visitDate - 1) * 100 + 1000;
        }
        return 0;
    }

    public static String detailsMent(int visitDate) {
        String detailsMent = "크리스마스 디데이 할인: -" + Parser.parseNumberCommaFormat(saleAmount(visitDate)) + "원\n";
        return detailsMent;
    }
}
