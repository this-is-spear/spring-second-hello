package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Imaspear on 2021-12-21
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class SingletonSerivceOtherTest {

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    public void singletonServiceTest() throws Exception{
        //given
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();
        //when
        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);
        //then
        //isSameAs 인스턴스 객체 메모리 주소 비교
        //equal 안의 데이터 비교
        Assertions.assertThat(singletonService1).isSameAs(singletonService2);
    }
    
    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    public void springContainer() throws Exception{
        //given
//        AppConfig appConfig = new AppConfig();
        //when
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);
        //then
//      위와 같이 호출할때마다 새로운 객체를 계속 생성한다.
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
        // memberServer1 != memberService2
//        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
        Assertions.assertThat(memberService1).isSameAs(memberService2);

    }
}
