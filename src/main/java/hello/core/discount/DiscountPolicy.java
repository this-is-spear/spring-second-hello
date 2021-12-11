package hello.core.discount;

import hello.core.member.Member;

/**
 * Created by Imaspear on 2021-12-11
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface DiscountPolicy {
    /*
    * <pre>
    *   hello.core.discount
    *   ㄴ DiscountPolicy.java
    * </pre>
    * @date : 2021-12-11 오후 6:07
    * @author : ImaSpear
    * @version : 1. 0. 0
    * @description : 할인 대상 금액
    * see :
    */
    int discount(Member member, int price);


}
