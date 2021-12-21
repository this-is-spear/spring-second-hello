package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Created by Imaspear on 2021-12-21
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class SingletonService {
    private static final SingletonService instance = new SingletonService();
    public static SingletonService getInstance(){
        return instance;
    }
    private SingletonService(){
        //기본 생성자를 private 으로 생성한다.
    };

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}
