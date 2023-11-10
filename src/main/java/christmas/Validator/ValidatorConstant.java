package christmas.Validator;

public enum ValidatorConstant {
    PARSE_INT_ERROR("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    VISIT_DATE_RANGE_ERROR("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    private final String message;

    ValidatorConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
