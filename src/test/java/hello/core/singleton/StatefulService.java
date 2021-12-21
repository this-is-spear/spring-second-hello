package hello.core.singleton;

/**
 * Created by Imaspear on 2021-12-21
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class StatefulService {
    private int price; // 상태를 유지하는 필드

    public void order(String name, int price){
        System.out.println("name+price = " + name + price);
        this.price = price; // 여기가 문제
    }

    public int getPrice() {
        return price;
    }
}
