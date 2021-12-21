package hello.core.beanDefinition;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Imaspear on 2021-12-20
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class BeanDefinitionTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//    ApplicationContext를 사용하려면 getBeanDefinition이 없다. 왜냐하면 실제 BeanDefinition 정보를 가져와 사용할 일이 전혀 없기 때문이다.
//    그래서 AnnotationConfigApplicationContext 타입의 객체를 생성했다.
    @Test
    @DisplayName("빈 설정 메타 정보 확인")
    public void findApplicationBean() throws Exception{
        //given
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        //when
        for(String beanDefinition: beanDefinitionNames){
            BeanDefinition definition = ac.getBeanDefinition(beanDefinition);
            if (definition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinition = " + beanDefinition + "definition =" + definition);
            }
        }
        //then

    }
}
