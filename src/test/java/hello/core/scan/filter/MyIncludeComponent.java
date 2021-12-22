package hello.core.scan.filter;

import java.lang.annotation.*;

/**
 * Created by Imaspear on 2021-12-22
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
}
