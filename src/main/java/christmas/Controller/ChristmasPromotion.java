package christmas.Controller;

import christmas.Model.User;
import christmas.Model.VisitDate;
import christmas.Parser;
import christmas.View.InputView;
import christmas.View.OutputView;

public class ChristmasPromotion {
    public void run() {
        VisitDate visitDate = saveVisitDate();
        User user = saveUser();
        OutputView.printPriviewTitle(visitDate.getVisitDate());
        OutputView.printAllOrderMenu(user.getAllMenuAndQuantity());
        OutputView.printBeforeSaleTotalPrice(Parser.parseNumberCommaFormat(user.calculateTotalPrice()));
    }

    private VisitDate saveVisitDate() {
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

    private User saveUser() {
        while (true) {
            try {
                String input = InputView.requestMenuAndQuantity();
                User user = new User(input);
                return user;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
