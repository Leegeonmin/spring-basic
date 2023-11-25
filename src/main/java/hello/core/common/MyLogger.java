package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

// proxy가 Provider처럼 작동. 껍데기처럼 이름만 존재 기능 호출 시점에 진짜 class를 찾아서 동작
@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message){
        System.out.println("[" + uuid + "] " + "[" + requestURL + "]" + message);
    }

    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean CREATE : " + this);
    }

    @PreDestroy
    public void destroy(){
        System.out.println("[" + uuid + "] request scope bean CLOSE : " + this);
    }
}
