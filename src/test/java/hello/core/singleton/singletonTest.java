package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Created by Imaspear on 2021-12-20
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class singletonTest {
    
    @Test
    @DisplayName("스프링이 없는 순수 DI 컨테이너")
    public void pureContainer() throws Exception{
        //given
        AppConfig appConfig = new AppConfig();
        //when
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();
        //then
//      위와 같이 호출할때마다 새로운 객체를 계속 생성한다.
//        System.out.println("memberService1 = " + memberService1);
//        System.out.println("memberService2 = " + memberService2);
        // memberServer1 != memberService2
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }
}
