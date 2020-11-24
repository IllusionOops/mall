package com.wyj.auth.feign.fallback;

import com.wyj.auth.entity.ResultBean;
import com.wyj.auth.feign.UserFeign;
import com.wyj.user.entity.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;


/**
 * @author wuyijie
 * @project mall
 * @className UserFeignFallbackFactory
 * @description TODO
 * @date 2020/11/14 22:42
 */

@Component
public class UserFeignFallbackFactory implements FallbackFactory<UserFeign> {
    @Override
    public UserFeign create(Throwable throwable) {
        final ResultBean resultBean = new ResultBean(500, "user服务暂不可用！！！", null);
        return new UserFeign() {
            @Override
            public ResultBean deleteByPrimaryKey(Integer id) {
                return resultBean;
            }

            @Override
            public ResultBean insert(User record) {
                return resultBean;
            }

            @Override
            public ResultBean selectByPrimaryKey(Integer id) {
                return resultBean;
            }

            @Override
            public ResultBean selectAll() {
                return resultBean;
            }

            @Override
            public ResultBean updateByPrimaryKey(User record) {
                return resultBean;
            }

            @Override
            public ResultBean getByUserName(String userName) {
                return resultBean;
            }
        };
    }
}
