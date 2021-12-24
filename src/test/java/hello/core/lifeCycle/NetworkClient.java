package hello.core.lifeCycle;

/**
 * Created by Imaspear on 2021-12-24
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("url = " + url);
        connect();
        call("초기화 연결 메시지");
    }
    
    public void connect(){
        System.out.println("connect : " + url);
    }
    
    public void call(String message){
        System.out.println("call : " + url + "message = "+message);
    }

    public void disconnect(){
        System.out.println("close : " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
