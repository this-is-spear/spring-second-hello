package hello.core.lifeCycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testng.annotations.Test;

/**
 * Created by Imaspear on 2021-12-24
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() throws Exception{
        // ApplicationContext에 close() 메서드를 기본 제공해주지 않는다.
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig{
        @Bean
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
