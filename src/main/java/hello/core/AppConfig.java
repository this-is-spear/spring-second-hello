package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderServiceImpl;
import hello.core.order.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Imaspear on 2021-12-13
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */

@Configuration
public class AppConfig {
    @Bean
    public MemberRepository memoryRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memoryRepository());
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memoryRepository(), discountPolicy());
    }
}
