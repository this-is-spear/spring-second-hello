package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

/**
 * Created by Imaspear on 2021-12-13
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price*discountPercent/100;
        }else{
            return 0;
        }
    }
}
