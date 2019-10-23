package com.netty.im.nettywebim.config;

import com.netty.im.nettywebim.netty.WebSocketService;
import com.netty.im.nettywebim.netty.impl.WebSocketServerImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Author M_YF
 * @Date 2019/10/22
 * @Description:
 */
@Slf4j
@Component
public class ImApplicationRunner implements ApplicationRunner {

    @Autowired
    private WebSocketService webSocketService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //启动webSocket 注：如果是公网服务器host必须配置为0.0.0.0
        webSocketService.start("0.0.0.0", 8090);
    }
}
