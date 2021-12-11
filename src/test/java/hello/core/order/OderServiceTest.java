package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Imaspear on 2021-12-11
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
class OderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OderServiceImpl();

    @Test
    public void createOrder() throws Exception{
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        //when
        Order order = orderService.createOrder(memberId,"itemA", 10000);
        //then
        System.out.println(order);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}