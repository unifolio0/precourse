package christmas.Validator;

public enum ValidatorConstant {
    VISIT_DATE_ERROR("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    MENU_AND_QUANTITY_ERROR("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    OVER_TOTAL_SIZE_ERROR("[ERROR] 최대 20개까지만 구매할 수 있습니다. 다시 입력해 주세요."),
    ONLY_BEVERAGE_ERROR("[ERROR] 음료만 주문할 수는 없습니다.");

    private final String message;

    ValidatorConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
