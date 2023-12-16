package oncall.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ASK_MONTH_START_DAY = "비상 근무를 배정할 월과 시작 요일을 입력하세요> ";
    private static final String ASK_DAY_PEOPLE = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";
    private static final String ASK_HOLIDAY_PEOPLE = "휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";

    public static String requireMonthDay() {
        System.out.print(ASK_MONTH_START_DAY);
        String input = Console.readLine();
        return input;
    }

    public static String requireDayPeople() {
        System.out.print(ASK_DAY_PEOPLE);
        String input = Console.readLine();
        return input;
    }

    public static String requireHolidayPeople() {
        System.out.print(ASK_HOLIDAY_PEOPLE);
        String input = Console.readLine();
        System.out.println();
        return input;
    }
}
