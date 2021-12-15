package hello.core.beanFind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Imaspear on 2021-12-15
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    
    @Test
    @DisplayName("모든 빈 출력하기")
    public void findAllBean () throws Exception{
        //given
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        //when
        for(String beanDefinitionName : beanDefinitionNames){
            Object bean = applicationContext.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName+ " object = " + bean);
        }
        //then
    }


    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    public void findApplicationBean () throws Exception{
        //given
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        //when
        for(String beanDefinitionName : beanDefinitionNames){
            BeanDefinition beanDefinition = applicationContext.getBeanDefinition(beanDefinitionName);
            // 스프링 컨테이너에 내가 등록한 빈
            //BeanDefinition.ROLE_APPLICATION
            // 스프링 컨테이너 내부 빈
            //BeanDefinition.ROLE_INFRASTRUCTURE
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = applicationContext.getBean(beanDefinitionName);
                System.out.println("ROLE_APPLICATION = " + beanDefinitionName+ " object = " + bean);
            }
        }
    }
}
