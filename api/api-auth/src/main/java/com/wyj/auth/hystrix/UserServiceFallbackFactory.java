package com.wyj.auth.hystrix;

import com.wyj.auth.api.AuthApi;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author wuyijie
 * @project mall
 * @className UserServiceFallbackFactory
 * @description TODO
 * @date 2020/11/8 18:14
 */
@Component
public class UserServiceFallbackFactory implements FallbackFactory<AuthApi> {
    @Override
    public AuthApi create(Throwable throwable) {

        return null;
    }
}
