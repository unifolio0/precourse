package pairmatching.View;

import java.util.Scanner;

public class InputView {
    private static final String OPTION_TITLE = "기능을 선택하세요.";
    private static final String OPTION1 = "1. 페어 매칭\n";
    private static final String OPTION2 = "2. 페어 조회\n";
    private static final String OPTION3 = "3. 페어 초기화\n";
    private static final String OPTION_QUIT = "Q. 종료";
    private static final String OPTION_TOTAL = OPTION1 + OPTION2 + OPTION3 + OPTION_QUIT;
    private static final String ASK_COURSE_LEVEL_MISSION = "과정, 레벨, 미션을 선택하세요.";
    private static final String EX_COURSE_LEVEL_MISSION = "ex) 백엔드, 레벨1, 자동차경주";
    private static final String ASK_RETRY = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?";
    private static final String RETRY_OPTION = "네 | 아니오";

    private static Scanner scan = new Scanner(System.in);

    public static String requireOption() {
        System.out.println(OPTION_TITLE);
        System.out.println(OPTION_TOTAL);
        String input = scan.nextLine();
        System.out.println();
        return input;
    }

    public static String requireCourseLevelMission() {
        System.out.println(ASK_COURSE_LEVEL_MISSION);
        System.out.println(EX_COURSE_LEVEL_MISSION);
        String input = scan.nextLine();
        System.out.println();
        return input;
    }

    public static String requireRetry() {
        System.out.println(ASK_RETRY);
        System.out.println(RETRY_OPTION);
        String input = scan.nextLine();
        System.out.println();
        return input;
    }
}
