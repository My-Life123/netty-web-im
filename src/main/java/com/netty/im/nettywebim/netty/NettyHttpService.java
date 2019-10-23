package com.netty.im.nettywebim.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @Author: M_YF
 * @Date: 2019/2/15 16:33
 * @Description:
 */
public interface NettyHttpService {
    void handleHttpRequset(ChannelHandlerContext ctx, FullHttpRequest request);
}
