package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryRepository;
import hello.core.order.OrderServiceImpl;
import hello.core.order.OrderService;

/**
 * Created by Imaspear on 2021-12-13
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */

public class AppConfig {

    private MemberRepository memoryRepository() {
        return new MemoryRepository();
    }

    private DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    public MemberService memberService(){
        return new MemberServiceImpl(memoryRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memoryRepository(), discountPolicy());
    }
}
