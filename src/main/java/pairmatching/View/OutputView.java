package pairmatching.View;

import java.util.List;

public class OutputView {
    private static final String RESET = "초기화 되었습니다.";

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public static void printPair(List<List<String>> lists) {
        for (List<String> names : lists) {
            System.out.println(String.join(" : ", names));
            System.out.println();
        }
    }

    public static void printReset() {
        System.out.println(RESET);
        System.out.println();
    }
}
