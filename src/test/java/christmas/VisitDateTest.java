package christmas;

import christmas.Model.VisitDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class VisitDateTest {
    @DisplayName("유효하지 않은 방문 날짜 입력 예외 처리")
    @ValueSource(strings = {
            "32", "0", "-12",    /*1~31의 범위를 벗어나는 경우*/
            "f", "12f", "1@", "1.1"    /*정수가 아닌 경우*/
    })
    @ParameterizedTest
    void VisitDateNotValidException(String input) {
        assertThatThrownBy(() -> new VisitDate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }
}
