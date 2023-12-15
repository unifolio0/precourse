package pairmatching.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String OPTION_TITLE = "기능을 선택하세요.";
    private static final String OPTION1 = "1. 페어 매칭\n";
    private static final String OPTION2 = "2. 페어 조회\n";
    private static final String OPTION3 = "3. 페어 초기화\n";
    private static final String OPTION_QUIT = "Q. 종료";
    private static final String OPTION_TOTAL = OPTION1 + OPTION2 + OPTION3 + OPTION_QUIT;
    private static final String DIVISION = "#############################################";
    private static final String COURSE_TITLE = "과정: 백엔드 | 프론트엔드";
    private static final String LEVEL_TITLE = "미션:";
    private static final String LEVEL1 = "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n";
    private static final String LEVEL2 = "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n";
    private static final String LEVEL3 = "  - 레벨3:\n";
    private static final String LEVEL4 = "  - 레벨4: 성능개선 | 배포\n";
    private static final String LEVEL5 = "  - 레벨5: ";
    private static final String LEVEL_TOTAL = LEVEL1 + LEVEL2 + LEVEL3 + LEVEL4 + LEVEL5;
    private static final String ASK_COURSE_LEVEL_MISSION = "과정, 레벨, 미션을 선택하세요.";
    private static final String EX_COURSE_LEVEL_MISSION = "ex) 백엔드, 레벨1, 자동차경주";
    private static final String ASK_RETRY = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?";
    private static final String RETRY_OPTION = "네 | 아니오";

    public static String requireOption() {
        System.out.println(OPTION_TITLE);
        System.out.println(OPTION_TOTAL);
        String input = Console.readLine();
        System.out.println();
        return input;
    }
    public static String requireCourseLevelMission() {
        System.out.println(DIVISION);
        System.out.println(COURSE_TITLE);
        System.out.println(LEVEL_TITLE);
        System.out.println(LEVEL_TOTAL);
        System.out.println(DIVISION);
        System.out.println(ASK_COURSE_LEVEL_MISSION);
        System.out.println(EX_COURSE_LEVEL_MISSION);
        String input = Console.readLine();
        return input;
    }

    public static String requireRetry() {
        System.out.println(ASK_RETRY);
        System.out.println(RETRY_OPTION);
        String input = Console.readLine();
        return input;
    }
}
