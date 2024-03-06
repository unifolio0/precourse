package oncall.View;

import java.util.List;

public class OutputView {
    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public static void printCalendar(List<String> calendar) {
        for (String str : calendar) {
            System.out.print(str);
        }
    }
}
