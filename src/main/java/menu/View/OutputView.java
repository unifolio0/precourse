package menu.View;

public class OutputView {
    private static final String LINE_BREAKING = "\n";
    private static final String OPEN_TITLE = "점심 메뉴 추천을 시작합니다.";

    public static void printOpenTitle() {
        System.out.println(OPEN_TITLE + LINE_BREAKING.repeat(2));
    }
}
