package hello.core.order;

/**
 * Created by Imaspear on 2021-12-11
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
