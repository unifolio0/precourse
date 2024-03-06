package oncall.Validator;

public enum ValidatorConstant {
    VALIDATE_MONTH_START_DAY("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요."),
    VALIDATE_PEOPLES("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");

    private final String message;

    ValidatorConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
