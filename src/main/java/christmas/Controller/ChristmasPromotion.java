package christmas.Controller;

import christmas.Model.VisitDate;
import christmas.Parser;
import christmas.Validator.Validator;
import christmas.View.InputView;
import christmas.View.OutputView;

import java.util.List;

public class ChristmasPromotion {
    public void run() {
        makeVisitDate();
        makeMenuAndCount();
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

    private void makeMenuAndCount() {
        while (true) {
            try {
                String input = InputView.requestMenuAndQuantity();
                List<String> pp = Parser.parseStringSplitComma(input);
                Validator.validateAllMenuAndQuantityRegularExpression(pp);
                return;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
