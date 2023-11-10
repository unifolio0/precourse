package christmas.Controller;

import christmas.Model.SaleInfomation;
import christmas.Model.User;
import christmas.Model.VisitDate;
import christmas.Parser;
import christmas.View.InputView;
import christmas.View.OutputView;

public class ChristmasPromotion {
    private VisitDate visitDate;
    private User user;

    public void run() {
        this.visitDate = saveVisitDate();
        this.user = saveUser();
        printOrderInformation();
        SaleInfomation saleInfomation = new SaleInfomation(visitDate.getVisitDate(), user.calculateTotalPrice());
        OutputView.printBonusMenu(saleInfomation.bonusMenuMent());
    }

    private VisitDate saveVisitDate() {
        OutputView.printGreeting();
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

    private void printOrderInformation() {
        OutputView.printPreviewTitle(visitDate.getVisitDate());
        OutputView.printAllOrderMenu(user.getAllMenuAndQuantity());
        int totalPrice = user.calculateTotalPrice();
        OutputView.printBeforeSaleTotalPrice(Parser.parseNumberCommaFormat(totalPrice));
    }
}
