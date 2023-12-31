package hello.core.discount;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {


        RateDiscountPolicy discountPolicy;
        @BeforeEach
        public void beforeEach(){
            AppConfig appConfig = new AppConfig();
            discountPolicy = new RateDiscountPolicy();
        }
        @Test
        @DisplayName("VIP는 10% 할인이 적용되어야 한다")
        void vip_o(){
            //given
            Member member = new Member(1L, "memberA", Grade.VIP);

            //when
                int discount = discountPolicy.discount(member, 10000);

                Assertions.assertThat(discount).isEqualTo(1000);
            //then
        }
        @Test
        @DisplayName("VIP가 아니면 10% 할인이 적용되면 안된다")
        void vip_X(){
                //given
                Member member = new Member(1L, "memberA", Grade.BASIC);

                //when
                int discount = discountPolicy.discount(member, 10000);

                Assertions.assertThat(discount).isEqualTo(0);
                //then
        }
}