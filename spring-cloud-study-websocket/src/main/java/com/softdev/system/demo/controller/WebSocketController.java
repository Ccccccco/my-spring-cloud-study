package com.softdev.system.demo.controller;

import com.softdev.system.demo.config.WebSocketServer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;



/**
 * @author:jichao
 * @date:2020/4/25-15:03
 * @description: WebSocketController
 **/
@RestController
public class WebSocketController {

    /**
     * @description: 测试方法
     **/
    @GetMapping("index")
    public ResponseEntity<String> index(){
        return ResponseEntity.ok("请求成功");
    }

    /**
     * @description: 测试方法
     **/
    @GetMapping("page")
    public ModelAndView page(){
        return new ModelAndView("websocket");
    }

    /**
     * @description: 根据Id推送消息
     **/
    @RequestMapping("/push/{toUserId}")
    public ResponseEntity<String> pushToWeb(String message, @PathVariable String toUserId) throws IOException {
        WebSocketServer.sendInfo(message,toUserId);
        return ResponseEntity.ok("MSG SEND SUCCESS");
    }


    /**
     * @description: 系统向所有用户推送消息
     **/
    @RequestMapping("/push/all")
    public ResponseEntity<String> pushAllToWeb(String message) throws IOException {
        WebSocketServer.sendInfoToAll(message);
        return ResponseEntity.ok("MSG SEND SUCCESS");
    }
}
