package christmas;

import christmas.Model.User;
import christmas.Validator.ValidatorConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    @DisplayName("적합한 입력에 대하여 Map을 정확히 생성하는지 테스트")
    @Test
    void makeUserMenuAndQuantity1() {
        User user = new User("양송이수프-3,바비큐립-2,레드와인-3");
        assertThat(user.getAllMenuAndQuantity())
                .isEqualTo(Map.of("양송이수프",3,"바비큐립",2,"레드와인",3));
    }

    @Test
    void makeUserMenuAndQuantity2() {
        User user = new User("아이스크림-3");
        assertThat(user.getAllMenuAndQuantity())
                .isEqualTo(Map.of("아이스크림",3));
    }

    @DisplayName("유효하지 않은 메뉴 입력 예외 처리")
    @ValueSource(strings = {
            "해산물-1", "양송이수프-4,초코이크-2,아이스크림-1", "양송이수프-4,초코 케이크-2,아이스크림-1", "양송이수프-1,-4,아이스크림-1",  /*메뉴판에 없는 메뉴를 입력한 경우*/
            "타파스-0", "해산물파스타-2,레드와인-0,초코케이크-1", "타파스--15",    /*메뉴의 갯수가 1미만인 경우*/
            "타파스-4j", "해산물파스타-2,레드와인-1개,초코케이크-1", "시저샐러드-1,바비큐립-five",  /*메뉴의 갯수가 정수가 아닌 경우*/
            "해산물파스타-2, 레드와인-1,초코케이크-1", "1-레드와인,2-해산물파스타", "레드와인1,아이스크림4",  /*메뉴 형식이 예시와 다른 경우*/
            "시저샐러드-1,바비큐립-1,시저샐러드-4",   /*중복 메뉴를 입력한 경우*/
            "시저샐러드-1,", "", ",시저샐러드-1", " ","해산물파스타-1,,레드와인-4",","    /*빈 문자열 또는 연결이 없는 쉼표가 있을 경우*/
    })
    @ParameterizedTest
    void userNotValidException(String input) {
        assertThatThrownBy(() -> new User(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidatorConstant.MENU_AND_QUANTITY_ERROR.getMessage());
    }

    @DisplayName("음료만 주문한 경우 예외 처리")
    @ValueSource(strings = {"레드와인-1", "레드와인-1,제로콜라-6"})
    @ParameterizedTest
    void userMenuOnlyBeverage(String input) {
        assertThatThrownBy(() -> new User(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidatorConstant.ONLY_BEVERAGE_ERROR.getMessage());
    }

    @DisplayName("총 20개를 초과하여 주문한 경우 예외 처리")
    @ValueSource(strings = {"양송이수프-21", "양송이수프-4,레드와인-5,바비큐립-6,제로콜라-5,샴페인-1"})
    @ParameterizedTest
    void userMenuOverSize(String input) {
        assertThatThrownBy(() -> new User(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidatorConstant.OVER_TOTAL_SIZE_ERROR.getMessage());
    }
}
