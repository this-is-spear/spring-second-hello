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
    // 분명 AutoAppConfig.class 안에 이 AppConfig 클래스가 실행되지 않도록 설정했는데, 설정이 되면서 memoryRepository 라는 빈 이름이 생겼다.
    // 그 외에 자동 등록을 하기 위해서 @Component 애너테이션을 붙였던 MemoryMemberRepository 클래스가 자동으로 등록이 되면서 같은 타입의 빈이 중복이 되어
    // 충돌이 일어났다..
    @Bean
    public MemberRepository memberRepository() {
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
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
