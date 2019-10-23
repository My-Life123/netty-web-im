package com.netty.im.nettywebim.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: M_YF
 * @Date: 2019/2/15 16:34
 * @Description:
 */
@Slf4j
public class WebSocketServerHandler extends SimpleChannelInboundHandler<Object> {


    private WebSocketService webSocketServiceImpl;

    private NettyHttpService httpServiceImpl;





    public WebSocketServerHandler(WebSocketService webSocketServiceImpl,
                                  NettyHttpService httpServiceImpl) {
        super();
        this.webSocketServiceImpl = webSocketServiceImpl;
        this.httpServiceImpl = httpServiceImpl;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        // TODO Auto-generated method stub
        ChannelId channel=ctx.channel().id();
        String channelIdStr=channel.asLongText();
        log.info("channelIdStr:"+channelIdStr);
        if(msg instanceof FullHttpRequest){
            httpServiceImpl.handleHttpRequset(ctx, (FullHttpRequest)msg);
        }else if(msg instanceof WebSocketFrame){
            webSocketServiceImpl.handleFrame(ctx, (WebSocketFrame)msg);
        }
    }



    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        // TODO Auto-generated method stub
        ctx.flush();
    }
}
