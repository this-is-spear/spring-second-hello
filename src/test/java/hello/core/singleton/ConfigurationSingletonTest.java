package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Imaspear on 2021-12-21
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class ConfigurationSingletonTest {
    @Test
    public void configurationTest() throws Exception{
        //given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //when
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
        //then
        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();
        System.out.println("memberService -> memberRepository = " + memberRepository1);
        System.out.println("orderService -> memberRepository1 = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }

    @Test
    public void configurationDeep() throws Exception{
        //given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //when
        AppConfig bean = ac.getBean(AppConfig.class);
        //then
        System.out.println("bean = " + bean.getClass());

    }
}
