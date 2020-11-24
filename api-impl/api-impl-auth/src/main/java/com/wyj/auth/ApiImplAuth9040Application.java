package com.wyj.auth;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wuyijie
 * @project mall
 * @className ApiImplAuth9040Application
 * @description TODO
 * @date 2020/11/15 00:52
 */
@SpringBootApplication
@EnableApolloConfig
@EnableDiscoveryClient
@EnableZuulProxy
@EnableRabbit
@EnableFeignClients
public class ApiImplAuth9040Application {
    public static void main(String[] args) {
        SpringApplication.run(ApiImplAuth9040Application.class,args);
    }
}
