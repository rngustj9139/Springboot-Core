package hello.core.discount;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

//    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    DiscountPolicy discountPolicy;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        this.discountPolicy = appConfig.discountPolicy();
    }


    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o() {
        Member member = new Member(1L, "Koo", Grade.VIP);

        int discountPrice = discountPolicy.discount(member, 10000);

        assertThat(discountPrice).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아닌경우 할인이 적용되지 않아야 한다.")
    void vip_x() {
        Member member = new Member(2L, "Kim", Grade.BASIC);

        int discountPrice = discountPolicy.discount(member, 10000);

        assertThat(discountPrice).isEqualTo(0);
    }

}