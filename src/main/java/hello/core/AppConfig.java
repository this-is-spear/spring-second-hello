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
//실제 예상하는 호출 순서
//call AppConfig.memoryRepository
//call AppConfig.memberService
//call AppConfig.memoryRepository <- memberService 안에서 call
//call AppConfig.orderService
//call AppConfig.memoryRepository <- orderService 안에서 call
//
// 스프링은 아래와 같이 실행한다.
//call AppConfig.memoryRepository
//call AppConfig.memberService
//call AppConfig.orderService


@Configuration
public class AppConfig {
    @Bean
    public MemberRepository memoryRepository() {
        System.out.println("call AppConfig.memoryRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memoryRepository());
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memoryRepository(), discountPolicy());
    }
}
