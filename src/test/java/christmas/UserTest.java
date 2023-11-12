package christmas;

import christmas.Model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    @DisplayName("유효하지 않은 메뉴 입력 예외 처리")
    @ValueSource(strings = {
            "해산물-1", "양송이수프-4,초코이크-2,아이스크림-1", "양송이수프-4,초코 케이크-2,아이스크림-1", "양송이수프-1,-4,아이스크림-1",  /*메뉴판에 없는 메뉴를 입력한 경우*/
            "타파스-0", "해산물파스타-2,레드와인-0,초코케이크-1", "타파스--15",    /*메뉴의 갯수가 1미만인 경우*/
            "타파스-4j", "해산물파스타-2,레드와인-1개,초코케이크-1", "시저샐러드-1,바비큐립-five",  /*메뉴의 갯수가 정수가 아닌 경우*/
            "시저샐러드-1,", "", ",시저샐러드-1", " ", "해산물파스타-2, 레드와인-1,초코케이크-1", "1-레드와인,2-해산물파스타", "레드와인1,아이스크림4",  /*메뉴 형식이 예시와 다른 경우*/
            "시저샐러드-1,바비큐립-1,시저샐러드-4" /*중복 메뉴를 입력한 경우*/
    })
    @ParameterizedTest
    void UserNotValidException(String input) {
        assertThatThrownBy(() -> new User(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("음료만 주문한 경우 예외 처리")
    @ValueSource(strings = {"레드와인-1", "레드와인-1,제로콜라-6"})
    @ParameterizedTest
    void UserMenuOnlyBeverage(String input) {
        assertThatThrownBy(() -> new User(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 음료만 주문할 수는 없습니다.");
    }

    @DisplayName("총 20개를 초과하여 주문한 경우 예외 처리")
    @ValueSource(strings = {"양송이수프-21", "양송이수프-4,레드와인-5,바비큐립-6,제로콜라-5,샴페인-1"})
    @ParameterizedTest
    void UserMenuOverSize(String input) {
        assertThatThrownBy(() -> new User(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 최대 20개까지만 구매할 수 있습니다. 다시 입력해 주세요.");
    }
}
