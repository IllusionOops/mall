package com.wyj.user;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author wuyijie
 * @project mall
 * @className ApiImplUser9030Application
 * @description TODO
 * @date 2020/11/15 00:07
 */

@SpringBootApplication
@EnableApolloConfig
@EnableDiscoveryClient
@EnableZuulProxy
@EnableRabbit
public class ApiImplUser9030Application {
    public static void main(String[] args) {
        SpringApplication.run(ApiImplUser9030Application.class,args);
    }
}
