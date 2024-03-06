package oncall;

import oncall.Model.MonthDay;
import oncall.Validator.ValidatorConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MonthDayTest {
    @DisplayName("해당 달에 1~12사이의 값이 아닌 다른 값을 입력한 경우 예외 처리")
    @ValueSource(strings = {"0,월", "13,화", "-7,월", "월,화"})
    @ParameterizedTest
    void monthDayErrorMonth(String input) {
        assertThatThrownBy(() -> new MonthDay(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidatorConstant.VALIDATE_MONTH_START_DAY.getMessage());
    }

    @DisplayName("요일을 잘못 입력한 경우 예외 처리")
    @ValueSource(strings = {"1,dnf", "5,워", "7,화수", "8,화요일", "8,4"})
    @ParameterizedTest
    void monthDayErrorDay(String input) {
        assertThatThrownBy(() -> new MonthDay(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidatorConstant.VALIDATE_MONTH_START_DAY.getMessage());
    }

    @DisplayName("인자 갯수를 잘못 입력한 경우 예외 처리")
    @ValueSource(strings = {"1,월,", "5,월,화", "7,화,5"})
    @ParameterizedTest
    void monthDayErrorInputSize(String input) {
        assertThatThrownBy(() -> new MonthDay(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidatorConstant.VALIDATE_MONTH_START_DAY.getMessage());
    }
}
