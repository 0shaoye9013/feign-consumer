package com.shaoye.cloud.web;

import com.shaoye.cloud.model.User;
import com.shaoye.cloud.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @param
 * @Author: ShaoYe
 * @Description:
 * @Date:
 */
@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;

    @GetMapping("/feign-consumer")
    public String helloConsumer(){
        return helloService.hello(new User("DIDI",30));
    }

    @GetMapping("/feign-consumer2")
    public String helloConsumer2(){
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello("DIDI")).append("\n");
        sb.append(helloService.hello("DIDI",30)).append("\n");
        sb.append(helloService.hello(new User("DIDI",30))).append("\n" +
                "");
        return sb.toString();
    }
}
