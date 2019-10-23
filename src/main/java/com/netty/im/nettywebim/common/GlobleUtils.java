package com.netty.im.nettywebim.common;

import io.netty.channel.Channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author M_YF
 * @Date 2019/10/23
 * @Description:
 */
public class GlobleUtils {

    public static final Map<String, Channel> socketChannelMap=new ConcurrentHashMap<>();
}
