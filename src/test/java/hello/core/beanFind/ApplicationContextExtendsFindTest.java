package hello.core.beanFind;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Imaspear on 2021-12-18
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class ApplicationContextExtendsFindTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면 중복 오류가 발생")
    public void findBeanByParentTypeDuplicate(){
        assertThrows(NoUniqueBeanDefinitionException.class, ()->applicationContext.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면 중복 오류가 발생")
    public void findBeanByParentTypeBeanName(){
        //given
        //when
        DiscountPolicy rateDiscountPolicy = applicationContext.getBean("rateDiscountPolicy",DiscountPolicy.class);
        //then
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("안 좋은 방법으로 특정 하위 타입 조회하는 방법")
    public void findBeanBySubType() throws Exception{
        //given
        //when
        RateDiscountPolicy rateDiscountPolicy = applicationContext.getBean(RateDiscountPolicy.class);
        //then
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기")
    public void findBeanByParentType() throws Exception{
        //given
        //when
        Map<String, DiscountPolicy> beansOfType = applicationContext.getBeansOfType(DiscountPolicy.class);
        //then
        assertThat(beansOfType.size()).isEqualTo(2);
        for (String key : beansOfType.keySet()){
            System.out.println("key + beansOfType.values() = " + key + beansOfType.values());
        }
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기 - object")
    public void findAllBeanByObjectType() throws Exception{
        //given
        //when
        Map<String, Object> beansOfType = applicationContext.getBeansOfType(Object.class);
        //then
        for (String key : beansOfType.keySet()){
            System.out.println("key + beansOfType.values() = " + key + beansOfType.values());
        }
    }

    @Configuration
    static class TestConfig{
        @Bean
        public DiscountPolicy rateDiscountPolicy(){
            return new RateDiscountPolicy();
        }
        @Bean
        public DiscountPolicy fixDiscountPolicy(){
            return new FixDiscountPolicy();
        }
    }
}
