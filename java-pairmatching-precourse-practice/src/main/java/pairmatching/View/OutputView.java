package pairmatching.View;

import java.util.List;

public class OutputView {
    private static final String DIVISION = "#############################################";
    private static final String COURSE_TITLE = "과정: 백엔드 | 프론트엔드";
    private static final String LEVEL_TITLE = "미션:";
    private static final String LEVEL1 = "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n";
    private static final String LEVEL2 = "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n";
    private static final String LEVEL3 = "  - 레벨3:\n";
    private static final String LEVEL4 = "  - 레벨4: 성능개선 | 배포\n";
    private static final String LEVEL5 = "  - 레벨5: ";
    private static final String LEVEL_TOTAL = LEVEL1 + LEVEL2 + LEVEL3 + LEVEL4 + LEVEL5;
    private static final String PRINT_PAIR_TITLE = "페어 매칭 결과입니다.";
    private static final String RESET = "초기화 되었습니다.";

    public static void printErrorMessage(String message) {
        System.out.println(message);
        System.out.println();
    }

    public static void printPairInformation() {
        System.out.println(DIVISION);
        System.out.println(COURSE_TITLE);
        System.out.println(LEVEL_TITLE);
        System.out.println(LEVEL_TOTAL);
        System.out.println(DIVISION);
    }

    public static void printPair(List<List<String>> lists) {
        System.out.println(PRINT_PAIR_TITLE);
        for (List<String> names : lists) {
            System.out.println(String.join(" : ", names));
        }
        System.out.println();
    }

    public static void printReset() {
        System.out.println(RESET);
        System.out.println();
    }
}
