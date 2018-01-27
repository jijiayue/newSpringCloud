package jjyy.controller;

import jjyy.remote.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sunwei0427 on 2018/1/17.
 */
@RestController
public class HelloController {

    @Autowired
    HelloRemote helloRemote;

    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {
        return helloRemote.hello(name);
    }

    //  访问路径相同  springCloud 会做负载均衡
//    @RequestMapping("/hello")
//    public String index(@RequestParam String name) {
//        return "hello "+name+"，this is producer 2  send first messge";
//    }


}
