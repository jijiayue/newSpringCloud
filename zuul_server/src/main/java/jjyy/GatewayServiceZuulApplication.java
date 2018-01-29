package jjyy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by sunwei0427 on 2018/1/29.
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class GatewayServiceZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceZuulApplication.class, args);
    }
}
