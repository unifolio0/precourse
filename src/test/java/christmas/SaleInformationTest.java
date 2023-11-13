package christmas;

import static christmas.SaleInformationTestInstance.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SaleInformationTest {
    @DisplayName("증정 이벤트 대상 여부를 정확히 도출하는 지 테스트 : 증정 대상이 아닐 때")
    @Test
    void checkBonusMenu() {
        assertThat(saleInformation1.findBonusMenu().getMent())
                .isEqualTo("없음");
    }

    @DisplayName("증정 이벤트 대상 여부를 정확히 도출하는 지 테스트 : 증정 대상일 때")
    @Test
    void checkNotBonusMenu() {
        assertThat(saleInformation2.findBonusMenu().getMent())
                .isEqualTo("샴페인 1개");
    }

    @DisplayName("혜택 내역을 정확히 출력하는지 테스트 1~9")
    @Test
    void detailsMentCheck1() {/*크리스마스 디데이 할인, 주말 할인을 받는 경우: 주말(1일)에 메인 메뉴 1개 포함 120,000원 미만 주문*/
        assertThat((saleInformation1.allDetailsMent()))
                .isEqualTo("크리스마스 디데이 할인: -1,000원\n주말 할인: -2,023원\n");
    }

    @Test
    void detailsMentCheck2() {/*크리스마스 디데이 할인, 주말 할인, 증정 이벤트를 받는 경우: 주말(16일)에 메인 메뉴 3개 포함 120,000원 이상 주문*/
        assertThat((saleInformation2.allDetailsMent()))
                .isEqualTo("크리스마스 디데이 할인: -2,500원\n주말 할인: -6,069원\n증정 이벤트: -25,000원\n");
    }

    @Test
    void detailsMentCheck3() {/*주말 할인, 증정 이벤트를 받는 경우: 25일 이후 주말(29일)에 메인 메뉴 3개 포함 120,000원 이상 주문*/
        assertThat((saleInformation3.allDetailsMent()))
                .isEqualTo("주말 할인: -6,069원\n증정 이벤트: -25,000원\n");
    }

    @Test
    void detailsMentCheck4() {/*할인 혜택이 없는 경우: 25일 이후 주말(29일)에 메인 메뉴 없이 120,000원 미만 주문*/
        assertThat((saleInformation4.allDetailsMent()))
                .isEqualTo("없음\n");
    }

    @Test
    void detailsMentCheck5() {/*크리스마스 디데이 할인, 특별 할인 받는 경우: 별표날(10일)에 디저트 없이 120,000원 미만 주문*/
        assertThat((saleInformation5.allDetailsMent()))
                .isEqualTo("크리스마스 디데이 할인: -1,900원\n특별 할인: -1,000원\n");
    }

    @Test
    void detailsMentCheck6() {/*크리스마스 디데이 할인, 평일 할인, 특별 할인 받는 경우: 별표날(25일)에 디저트 2개 포함 120,000원 미만 주문*/
        assertThat((saleInformation6.allDetailsMent()))
                .isEqualTo("크리스마스 디데이 할인: -3,400원\n평일 할인: -4,046원\n특별 할인: -1,000원\n");
    }

    @Test
    void detailsMentCheck7() {/*평일 할인, 특별 할인, 증정 이벤트를 받는 경우: 25일 이후 별표날(31일)에 디저트 5개 포함 120,000원 이상 주문한 경우*/
        assertThat((saleInformation7.allDetailsMent()))
                .isEqualTo("평일 할인: -10,115원\n특별 할인: -1,000원\n증정 이벤트: -25,000원\n");
    }

    @Test
    void detailsMentCheck8() {/*할인 혜택이 없는 경우: 10,000원 미만 주문한 경우*/
        assertThat((saleInformation8.allDetailsMent()))
                .isEqualTo("없음\n");
    }

    @Test
    void detailsMentCheck9() {/*증명 이벤트 받는 경우: 25일 이후 평일(28일)에 디저트 없이 120,000원 이상 주문한 경우*/
        assertThat((saleInformation9.allDetailsMent()))
                .isEqualTo("증정 이벤트: -25,000원\n");
    }

    @DisplayName("총혜택 금액을 정확히 도출하는 지 테스트 1~9")
    @Test
    void calculateTotalBenefitPrice1() {
        assertThat((saleInformation1.findTotalBenefitPrice()))
                .isEqualTo(-3023);
    }

    @Test
    void calculateTotalBenefitPrice2() {
        assertThat((saleInformation2.findTotalBenefitPrice()))
                .isEqualTo(-33569);
    }

    @Test
    void calculateTotalBenefitPrice3() {
        assertThat((saleInformation3.findTotalBenefitPrice()))
                .isEqualTo(-31069);
    }

    @Test
    void calculateTotalBenefitPrice4() {
        assertThat((saleInformation4.findTotalBenefitPrice()))
                .isEqualTo(0);
    }

    @Test
    void calculateTotalBenefitPrice5() {
        assertThat((saleInformation5.findTotalBenefitPrice()))
                .isEqualTo(-2900);
    }

    @Test
    void calculateTotalBenefitPrice6() {
        assertThat((saleInformation6.findTotalBenefitPrice()))
                .isEqualTo(-8446);
    }

    @Test
    void calculateTotalBenefitPrice7() {
        assertThat((saleInformation7.findTotalBenefitPrice()))
                .isEqualTo(-36115);
    }

    @Test
    void calculateTotalBenefitPrice8() {
        assertThat((saleInformation8.findTotalBenefitPrice()))
                .isEqualTo(0);
    }

    @Test
    void calculateTotalBenefitPrice9() {
        assertThat((saleInformation9.findTotalBenefitPrice()))
                .isEqualTo(-25000);
    }

    @DisplayName("할인 후 예상 결제 금액을 정확히 도출하는 지 테스트")
    @Test
    void calculateActialPayment1() {
        assertThat((saleInformation1.calculateActialPayment()))
                .isEqualTo(78977);
    }

    @Test
    void calculateActialPayment2() {
        assertThat((saleInformation2.calculateActialPayment()))
                .isEqualTo(173431);
    }

    @Test
    void calculateActialPayment3() {
        assertThat((saleInformation3.calculateActialPayment()))
                .isEqualTo(173931);
    }

    @Test
    void calculateActialPayment4() {
        assertThat((saleInformation4.calculateActialPayment()))
                .isEqualTo(62000);
    }

    @Test
    void calculateActialPayment5() {
        assertThat((saleInformation5.calculateActialPayment()))
                .isEqualTo(89100);
    }

    @Test
    void calculateActialPayment6() {
        assertThat((saleInformation6.calculateActialPayment()))
                .isEqualTo(91554);
    }

    @Test
    void calculateActialPayment7() {
        assertThat((saleInformation7.calculateActialPayment()))
                .isEqualTo(125885);
    }

    @Test
    void calculateActialPayment8() {
        assertThat((saleInformation8.calculateActialPayment()))
                .isEqualTo(6000);
    }

    @Test
    void calculateActialPayment9() {
        assertThat((saleInformation9.calculateActialPayment()))
                .isEqualTo(166000);
    }
}
