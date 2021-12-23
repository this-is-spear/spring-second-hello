package hello.core.scan.filter;

import net.minidev.json.writer.BeansMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Imaspear on 2021-12-22
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class ComponentFilterAppConfigTest {
    @Test
    public void filterScan () throws Exception{
        //given
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentFilterAppConifg.class);
        //when
        BeanA beanA = applicationContext.getBean("beanA", BeanA.class);
        //then
        assertThat(beanA).isNotNull();
        assertThrows(NoSuchBeanDefinitionException.class,
                ()->  applicationContext.getBean("beanB", BeanB.class)
        );
    }

    @Configuration
    @ComponentScan(
            includeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
            excludeFilters = {
                    @Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class),
//                    @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = BeanA.class)
            }
    )
    static class ComponentFilterAppConifg{

    }
}
