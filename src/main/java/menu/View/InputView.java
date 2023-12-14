package menu.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String LINE_BREAKING = "\n";
    private static final String ASK_COACHES_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String ASK_NOT_EAT_MENU = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";

    public static String requireCoachesName() {
        System.out.println(ASK_COACHES_NAME);
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    public static String requireNotEatMenu(String name) {
        System.out.printf(ASK_NOT_EAT_MENU + LINE_BREAKING, name);
        String input = Console.readLine();
        System.out.println();
        return input;
    }
}
