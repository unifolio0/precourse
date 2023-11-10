package christmas.Controller;

import christmas.Model.VisitDate;
import christmas.View.InputView;
import christmas.View.OutputView;

public class ChristmasPromotion {
    public void run() {
        makeVisitDate();
    }

    private VisitDate makeVisitDate() {
        while (true) {
            try {
                String userInput = InputView.requestVisitDate();
                VisitDate visitDate = new VisitDate(userInput);
                return visitDate;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
