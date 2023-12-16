package oncall;

import oncall.Model.Peoples;
import oncall.Validator.ValidatorConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PeoplesTest {
    @DisplayName("5명 미만으로 입력했을 때 예외처리")
    @ValueSource(strings = {"도니,하비", "클라라", " "})
    @ParameterizedTest
    void peoplesUnderSize(String input) {
        assertThatThrownBy(() -> new Peoples(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidatorConstant.VALIDATE_MONTH_START_DAY.getMessage());
    }

    @DisplayName("35명 초과로 입력했을 때 예외처리")
    @ValueSource(strings = {"도니,하비,클라라,사슴,토끼,말,호랑이,고양이,버스,강아지,택시,용,쥐,소,뱀,달걀,가방,노트북,충전기,핸드폰,나무늘보,우아한,테크코스,최종,코테,설문,조사,종료,퇴실,테스트,범고래,마우스,키보드,우상,책상,바닥"})
    @ParameterizedTest
    void peoplesOverSize(String input) {
        assertThatThrownBy(() -> new Peoples(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidatorConstant.VALIDATE_MONTH_START_DAY.getMessage());
    }

    @DisplayName("이름이 5글자를 넘었을 때 예외 처리")
    @ValueSource(strings = {"도니,하비,클라라보이스,다이소,말", "토끼,호랑이,고양이,사자,메머드,티라노사우르스"})
    @ParameterizedTest
    void peoplesNameUnderSize(String input) {
        assertThatThrownBy(() -> new Peoples(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidatorConstant.VALIDATE_MONTH_START_DAY.getMessage());
    }

    @DisplayName("이름이 중복될 때 예외 처리")
    @ValueSource(strings = {"도니,하비,하비,다이소,말", "도니,호랑이,말,사슴,돼지,호랑이,터키"})
    @ParameterizedTest
    void peoplesNameDuplicate(String input) {
        assertThatThrownBy(() -> new Peoples(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidatorConstant.VALIDATE_MONTH_START_DAY.getMessage());
    }

    @DisplayName("두 집단이 다를 때 예외 처리")
    @Test
    void peoplesNotEqual() {
        Peoples peoples1 = new Peoples("도니,토끼,호랑이,사자,사슴,말");
        Peoples peoples2 = new Peoples("도니,토끼,사자,별,사슴,호랑이");
        assertThatThrownBy(() -> peoples1.checkPeoples(peoples2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidatorConstant.VALIDATE_MONTH_START_DAY.getMessage());
    }
}
