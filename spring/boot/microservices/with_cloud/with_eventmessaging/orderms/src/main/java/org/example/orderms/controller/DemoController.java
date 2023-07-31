package org.example.orderms.controller;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private StreamBridge bridge;

    public DemoController(StreamBridge bridge){
        this.bridge=bridge;
    }

    @PostMapping("/msg")
    public void createMessage(@RequestBody String msg){
        bridge.send("uppercaseFn-in-0",msg);

    }

}
