package christmas.Controller;

import christmas.Model.*;
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
        SaleInformation saleInformation = new SaleInformation(visitDate.getVisitDate(), user);
        OutputView.printBonusMenu(saleInformation.findBonusMenu().getMent());
        OutputView.printBenefitDetails(saleInformation.allDetailsMent());
        OutputView.printAllBenefitPrice(Parser.parseNumberCommaFormat(saleInformation.findTotalBenefitPrice()));
        OutputView.printActualPayment(Parser.parseNumberCommaFormat(saleInformation.calculateActialPayment()));
        EventBadge eventBadge = EventBadge.valueOf(saleInformation.findTotalBenefitPrice());
        OutputView.printEventBadge(eventBadge.getBadgeName());
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
