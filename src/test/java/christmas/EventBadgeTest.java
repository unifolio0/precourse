package christmas;

import christmas.Model.EventBadge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static christmas.SaleInformationTestInstance.*;

import static org.assertj.core.api.Assertions.assertThat;

public class EventBadgeTest {
    @DisplayName("정확한 이벤트 베지를 도출하는 지 테스트")
    @Test
    void findEventBadge1() {
        assertThat(EventBadge.valueOf(saleInformation1.findTotalBenefitPrice()))
                .isEqualTo(EventBadge.NOTHING);
    }

    @Test
    void findEventBadge2() {
        assertThat(EventBadge.valueOf(saleInformation2.findTotalBenefitPrice()))
                .isEqualTo(EventBadge.SANTA);
    }

    @Test
    void findEventBadge3() {
        assertThat(EventBadge.valueOf(saleInformation3.findTotalBenefitPrice()))
                .isEqualTo(EventBadge.SANTA);
    }

    @Test
    void findEventBadge4() {
        assertThat(EventBadge.valueOf(saleInformation4.findTotalBenefitPrice()))
                .isEqualTo(EventBadge.NOTHING);
    }

    @Test
    void findEventBadge5() {
        assertThat(EventBadge.valueOf(saleInformation5.findTotalBenefitPrice()))
                .isEqualTo(EventBadge.NOTHING);
    }

    @Test
    void findEventBadge6() {
        assertThat(EventBadge.valueOf(saleInformation6.findTotalBenefitPrice()))
                .isEqualTo(EventBadge.STAR);
    }

    @Test
    void findEventBadge7() {
        assertThat(EventBadge.valueOf(saleInformation7.findTotalBenefitPrice()))
                .isEqualTo(EventBadge.SANTA);
    }

    @Test
    void findEventBadge8() {
        assertThat(EventBadge.valueOf(saleInformation8.findTotalBenefitPrice()))
                .isEqualTo(EventBadge.NOTHING);
    }

    @Test
    void findEventBadge9() {
        assertThat(EventBadge.valueOf(saleInformation9.findTotalBenefitPrice()))
                .isEqualTo(EventBadge.SANTA);
    }

    @Test
    void findEventBadge10() {
        assertThat(EventBadge.valueOf(saleInformation10.findTotalBenefitPrice()))
                .isEqualTo(EventBadge.TREE);
    }
}
