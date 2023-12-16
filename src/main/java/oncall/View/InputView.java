package oncall.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ASK_MONTH_START_DAY = "비상 근무를 배정할 월과 시작 요일을 입력하세요> ";

    public static String requireMonthDay() {
        System.out.print(ASK_MONTH_START_DAY);
        String input = Console.readLine();
        return input;
    }
}
