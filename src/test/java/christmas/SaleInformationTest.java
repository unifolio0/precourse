package christmas;

import christmas.Model.SaleInformation;
import christmas.Model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SaleInformationTest {
    @DisplayName("증정 이벤트 대상 여부를 정확히 도출하는 지 테스트 : 증정 대상일 때")
    @Test
    void checkBonusMenu() {
        String input = "티본스테이크-2,아이스크림-2";
        SaleInformation saleInformation = new SaleInformation(14, new User(input));
        assertThat(saleInformation.findBonusMenu().getMent())
                .isEqualTo("샴페인 1개");
    }

    @DisplayName("증정 이벤트 대상 여부를 정확히 도출하는 지 테스트 : 증정 대상이 아닐 때")
    @Test
    void checkNotBonusMenu() {
        String input = "양송이수프-1,티본스테이크-1,초코케이크-2,제로콜라-2";
        SaleInformation saleInformation = new SaleInformation(14, new User(input));
        assertThat(saleInformation.findBonusMenu().getMent())
                .isEqualTo("없음");
    }
}
