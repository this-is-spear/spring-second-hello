package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * Created by Imaspear on 2021-12-22
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */

// @Configuration 애너테이션에 Component 애너테이션이 내장되어 있는데 @ComponentScan을 붙일 수 있을까?
@Configuration
@ComponentScan(
        basePackages = "hello.core",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) //지정한 파일은 뺄 거라는 명령어
        //Configuration 클래스를 제외하려고 한다. 우리는 Configuration 애너테이션이 붙은 AppConfig 클래스를 이용하고 있기에 충돌한다.
        // Configuration 애너테이션에도 Component 애너테이션이 붙어 있기 떄문에 CoreApplication 클래스에 붙은 SpringBootApplication 애너테이션에 내제되어 있는
        // ComponentScan 애너테이션 때문에 Configuration 애너테이션을 자동으로 읽는다.
        //AppConfig 클래스가 먼저 설정되면 어떡하지?
)
public class AutoAppConfig {

}
