package christmas;

import christmas.Model.SaleInformation;
import christmas.Model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("혜택 내역을 정확히 출력하는지 테스트")
    @Test
    void detailsMentCheck1() {/*크리스마스 디데이 할인, 주말 할인을 받는 경우: 주말(1일)에 메인 메뉴 1개 포함 120,000원 미만 주문*/
        String input = "양송이수프-2,티본스테이크-1,초코케이크-1";
        SaleInformation saleInformation = new SaleInformation(1, new User(input));
        assertThat((saleInformation.allDetailsMent()))
                .isEqualTo("크리스마스 디데이 할인: -1,000원\n주말 할인: -2,023원\n");
    }

    @Test
    void detailsMentCheck2() {/*크리스마스 디데이 할인, 주말 할인, 증정 이벤트를 받는 경우: 주말(16일)에 메인 메뉴 3개 포함 120,000원 이상 주문*/
        String input = "양송이수프-2,티본스테이크-3,아이스크림-1";
        SaleInformation saleInformation = new SaleInformation(16, new User(input));
        assertThat((saleInformation.allDetailsMent()))
                .isEqualTo("크리스마스 디데이 할인: -2,500원\n주말 할인: -6,069원\n증정 이벤트: -25,000원\n");
    }

    @Test
    void detailsMentCheck3() {/*주말 할인, 증정 이벤트를 받는 경우: 25일 이후 주말(29일)에 메인 메뉴 3개 포함 120,000원 이상 주문*/
        String input = "양송이수프-2,티본스테이크-1,바비큐립-2,아이스크림-1";
        SaleInformation saleInformation = new SaleInformation(29, new User(input));
        assertThat((saleInformation.allDetailsMent()))
                .isEqualTo("주말 할인: -6,069원\n증정 이벤트: -25,000원\n");
    }

    @Test
    void detailsMentCheck4() {/*할인 혜택이 없는 경우: 25일 이후 주말(29일)에 메인 메뉴 없이 120,000원 미만 주문*/
        String input = "양송이수프-2,초코케이크-3,아이스크림-1";
        SaleInformation saleInformation = new SaleInformation(29, new User(input));
        assertThat((saleInformation.allDetailsMent()))
                .isEqualTo("없음\n");
    }

    @Test
    void detailsMentCheck5() {/*크리스마스 디데이 할인, 특별 할인 받는 경우: 별표날(10일)에 디저트 없이 120,000원 미만 주문*/
        String input = "양송이수프-2,티본스테이크-1,샴페인-1";
        SaleInformation saleInformation = new SaleInformation(10, new User(input));
        assertThat((saleInformation.allDetailsMent()))
                .isEqualTo("크리스마스 디데이 할인: -1,900원\n특별 할인: -1,000원\n");
    }

    @Test
    void detailsMentCheck6() {/*크리스마스 디데이 할인, 평일 할인, 특별 할인 받는 경우: 별표날(25일)에 디저트 2개 포함 120,000원 미만 주문*/
        String input = "양송이수프-2,티본스테이크-1,초코케이크-2,제로콜라-1";
        SaleInformation saleInformation = new SaleInformation(25, new User(input));
        assertThat((saleInformation.allDetailsMent()))
                .isEqualTo("크리스마스 디데이 할인: -3,400원\n평일 할인: -4,046원\n특별 할인: -1,000원\n");
    }

    @Test
    void detailsMentCheck7() {/*평일 할인, 특별 할인, 증정 이벤트를 받는 경우: 25일 이후 별표날(31일)에 디저트 5개 포함 120,000원 이상 주문한 경우*/
        String input = "시저샐러드-4,초코케이크-2,레드와인-1,아이스크림-3";
        SaleInformation saleInformation = new SaleInformation(31, new User(input));
        assertThat((saleInformation.allDetailsMent()))
                .isEqualTo("평일 할인: -10,115원\n특별 할인: -1,000원\n증정 이벤트: -25,000원\n");
    }

    @Test
    void detailsMentCheck8() {/*할인 혜택이 없는 경우: 10,000원 미만 주문한 경우*/
        String input = "양송이수프-1";
        SaleInformation saleInformation = new SaleInformation(3, new User(input));
        assertThat((saleInformation.allDetailsMent()))
                .isEqualTo("없음\n");
    }

    @Test
    void detailsMentCheck9() {/*증명 이벤트 받는 경우: 25일 이후 평일(28일)에 디저트 없이 120,000원 이상 주문한 경우*/
        String input = "양송이수프-1,크리스마스파스타-4,레드와인-1";
        SaleInformation saleInformation = new SaleInformation(28, new User(input));
        assertThat((saleInformation.allDetailsMent()))
                .isEqualTo("증정 이벤트: -25,000원\n");
    }
}
