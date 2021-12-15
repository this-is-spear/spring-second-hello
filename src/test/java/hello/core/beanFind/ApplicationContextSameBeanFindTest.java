package hello.core.beanFind;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
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
 * Created by Imaspear on 2021-12-15
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class ApplicationContextSameBeanFindTest {
    //given
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시 같은 타입의 둘 이상 있으면 중복 요류")
    public void findBeanByTypeDuplicate(){
//        MemberRepository bean = applicationContext.getBean(MemberRepository.class);
        assertThrows(NoUniqueBeanDefinitionException.class, ()-> applicationContext.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입의 둘 이상 있으면, 빈 이름을 지정하자")
    public void findBeanByName(){
        MemberRepository memberRepository = applicationContext.getBean("memberRepository1",MemberRepository.class);
        assertThat(memberRepository).isInstanceOf(MemoryMemberRepository.class);
    }

    @Test
    @DisplayName("특정 타입 빈 모두 조회")
    public void findByType() throws Exception {
        //given
        Map<String, MemberRepository> beansOfType = applicationContext.getBeansOfType(MemberRepository.class);
        //when
        for(String key : beansOfType.keySet()){
            System.out.println("key = " + key);
            System.out.println("beansOfType = " + beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        //then
        assertThat(beansOfType.size()).isEqualTo(2);
    }

    // 해당 테스트에만 아래의 컨테이너를 사용하려고 이너 클래스를 생성해 스코프를 좁혔다.
    @Configuration
    static class SameBeanConfig{
        @Bean
        public MemberRepository memberRepository1(){
            return new MemoryMemberRepository();
        }
        @Bean
        public MemberRepository memberRepository2(){
            return new MemoryMemberRepository();
        }
    }
}
