package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by Imaspear on 2021-12-13
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();
//  테스트는 성공 사례와 실패 사례 두개 다 생성해서 테스트 해봐야 한다.
    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 합니다.")
    public void vip_o() throws Exception{
        //given
        Member member = new Member(1L, "memberVip", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }
    @Test
    @DisplayName("BASIC은 할인이 적용되면 안됩니다.")
    public void basic_x() throws Exception{
        //given
        Member member = new Member(2L, "memberBasic", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(0);
    }

}