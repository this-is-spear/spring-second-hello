package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Imaspear on 2021-12-21
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
class StatefulServiceTest {

    @Test
    public void statceServiceSingleton() throws Exception{
        //given
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);
        //when
        //ThreadA: A 사용자 10000원
        statefulService1.order("userA", 10000);
        //ThreadA: B 사용자 20000원
        statefulService2.order("userB", 20000);
        //then
        int price = statefulService1.getPrice();
//        int price = statefulService2.getPrice();
        System.out.println("price = " + price);

        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }
    static class TestConfig{
        @Bean StatefulService statefulService(){
            return new StatefulService();
        }
    }

}