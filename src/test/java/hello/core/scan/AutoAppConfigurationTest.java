package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Imaspear on 2021-12-22
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class AutoAppConfigurationTest {

    @Test
    public void basicAllScan() throws Exception{
        //given
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        //when
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
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

    @Test
    public void basicScan() throws Exception{
        //given
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        //when
        MemberService bean = applicationContext.getBean(MemberService.class);
        //then
        Assertions.assertThat(bean).isInstanceOf(MemberService.class);
    }
}
