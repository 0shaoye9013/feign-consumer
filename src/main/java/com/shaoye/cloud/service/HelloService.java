package com.shaoye.cloud.service;

import com.shaoye.cloud.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @param
 * @Author: ShaoYe
 * @Description:
 * @Date:
 */
@FeignClient("hello-server")
public interface HelloService {

    @RequestMapping(value = "/hello")
    String hello();

    @RequestMapping(value = "/hello1" )
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello2")
    String hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/hello3",method = RequestMethod.POST)
    String hello(@RequestBody User user);
}
