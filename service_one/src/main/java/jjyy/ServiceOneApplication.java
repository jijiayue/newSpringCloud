package jjyy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sunwei0427 on 2018/1/16.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@RestController
public class ServiceOneApplication {
    @GetMapping("/serviceOne")
    public String service0(){
        return "serviceOne";
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceOneApplication.class, args);
    }
}
