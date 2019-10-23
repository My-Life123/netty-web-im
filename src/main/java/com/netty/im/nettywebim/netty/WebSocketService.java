package com.netty.im.nettywebim.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;

/**
 * @Author: M_YF
 * @Date: 2019/2/15 16:32
 * @Description:
 */
public interface WebSocketService {

    void start(String host,int port);

    void handleFrame(ChannelHandlerContext ctx, WebSocketFrame frame);

    void  sendMessage(String message);

    boolean sendMessage(String channelId, String message);
}
