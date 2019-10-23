package com.netty.im.nettywebim.controller;

import com.alibaba.fastjson.JSONObject;
import com.netty.im.nettywebim.common.GlobleUtils;
import com.netty.im.nettywebim.common.JSONResponse;
import com.netty.im.nettywebim.netty.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author M_YF
 * @Date 2019/10/23
 * @Description:
 */
@RestController
@RequestMapping("message")
public class MessageController {

    @Autowired
    private WebSocketService webSocketService;

    @GetMapping("sentText")
    public JSONResponse sentText(String channelId, String message){
        if(webSocketService.sendMessage(channelId,message)) {
            return JSONResponse.Create(true, "发送成功！");
        }else {
            return JSONResponse.Create(false, "发送失败！");
        }
    }

    //获得服务端所有channel
    @GetMapping("getChannellAll")
    public JSONResponse getChannellAll(){
        return JSONResponse.Create(true,"操作成功！",
                JSONObject.toJSONString(GlobleUtils.socketChannelMap.keySet()));
    }

}
