package hello.core.beanFind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Imaspear on 2021-12-15
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class ApplicationContextBasicFindTest {
    //given
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    
    @Test
    @DisplayName("빈 이름으로 조회")
    public void findBeanByName() throws Exception{
        //then
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        //when
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    public void findBeanByType() throws Exception{
        //then
        MemberService memberService = applicationContext.getBean(MemberService.class);
        //then
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    // 구현체를 이용해 조회는 좋지 않지만 어쩔 수 없이 사용하는 경우도 생각해야 한다.
    @Test
    @DisplayName("구체 타이으로 조회")
    public void findBeanByName2() throws Exception{
        //when
        MemberService memberService = applicationContext.getBean("memberService", MemberServiceImpl.class);
        //then
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    
    // 실패 예외도 항상 체크하자
    @Test
    @DisplayName("빈 이름으로 조회하는데 없음")
    public void findBeanByNameX() throws Exception{
        //when, then
        assertThrows(NoSuchBeanDefinitionException.class, () -> applicationContext.getBean("xxxxx", MemberService.class));
    }

    //getBeansOfType()

}
