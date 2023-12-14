package menu.View;

import java.util.List;

public class OutputView {
    private static final String LINE_BREAKING = "\n";
    private static final String OPEN_TITLE = "점심 메뉴 추천을 시작합니다.";
    private static final String MENU_RECOMMEND_TITLE = "메뉴 추천 결과입니다.";
    private static final String MENU_RECOMMEND_DAY = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String END_TITLE = "추천을 완료했습니다.";

    public static void printOpenTitle() {
        System.out.println(OPEN_TITLE + LINE_BREAKING);
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public static void printMenuRecommed(String chategoryAnswer, List<String> detailAnswers) {
        System.out.println(MENU_RECOMMEND_TITLE);
        System.out.println(MENU_RECOMMEND_DAY);
        System.out.println(chategoryAnswer);
        for (String detailAnswer : detailAnswers) {
            System.out.println(detailAnswer);
        }
        System.out.println(LINE_BREAKING + END_TITLE);
    }
}
