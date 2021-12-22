package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

/**
 * Created by Imaspear on 2021-12-22
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class AutowiredTest {

    @Test
    public void AutowiredOption() throws Exception{
        ApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(TestBean.class);
    }
    //Optional, @Nullable은 스프링 전반에 걸쳐 지원한다. 예를 들어 생성자 자동 주입에서 특정 필드만 사용해도 된다.
    static class TestBean{
        //(required = false) 이 명령어가 없다면 에러가 난다.
        // 하지만 의존관계가 없으면 아래 메소드는 아예 호출이 되지 않는다.
        // Member는 스프링 빈이 아니기 때문에 호출이 되지 않는다.
        @Autowired(required = false)
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1 = " + noBean1);
        }
        @Autowired
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("noBean3 = " + noBean3);
        }

    }
}
