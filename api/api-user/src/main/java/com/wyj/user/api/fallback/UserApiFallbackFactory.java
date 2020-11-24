package com.wyj.user.api.fallback;

import com.wyj.auth.entity.ResultBean;
import com.wyj.user.api.UserApi;
import com.wyj.user.entity.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuyijie
 * @project mall
 * @className UserApiFallbackFactory
 * @description TODO
 * @date 2020/11/13 23:36
 */
@Component
public class UserApiFallbackFactory implements FallbackFactory<UserApi> {
    @Override
    public UserApi create(Throwable throwable) {
        final ResultBean result = new ResultBean(500,"user 服务不可用",null);

        return new UserApi() {
            @Override
            public ResultBean deleteByPrimaryKey(Integer id) {
                return result;
            }

            @Override
            public ResultBean insert(User record) {
                return result;
            }

            @Override
            public ResultBean selectByPrimaryKey(Integer id) {
                return result;
            }

            @Override
            public ResultBean selectAll() {
                return result;
            }

            @Override
            public ResultBean updateByPrimaryKey(User record) {
                return null;
            }

            @Override
            public ResultBean getByUserName(String userName) {
                return null;
            }
        };
    }
}
