package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

/**
 * Created by Imaspear on 2021-12-24
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
@Service
@RequiredArgsConstructor
public class LogDemoService {
//    private final ObjectProvider<MyLogger> myLoggerObjectProvider;
    private final MyLogger myLogger;

    public void logic(String id) {
        myLogger.log("Service id = " + id);
    }
}
