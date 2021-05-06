package edu.feng.trend.config;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @program: trendParentProject
 * @description: TODO
 * @author: feng
 * @create: 2020-05-11 09:08
 * @version: 1.0
 */

// 监听器，application启动后发现有这个监听器就注入，然后获取到端口号
@Component
public class IpConfiguration implements ApplicationListener<WebServerInitializedEvent> {
    private int serverPort;

    @Override
    public void onApplicationEvent(WebServerInitializedEvent webServerInitializedEvent) {
        this.serverPort = webServerInitializedEvent.getWebServer().getPort();
    }

    public int getPort() {
        return this.serverPort;
    }
}