package com.wyj.auth.feign;

import com.wyj.auth.entity.ResultBean;
import com.wyj.auth.feign.fallback.UserFeignFallbackFactory;
import com.wyj.user.api.UserApi;
import com.wyj.user.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author wuyijie
 * @project mall
 * @className UserFeign
 * @description TODO
 * @date 2020/11/14 22:41
 */
@FeignClient(value = "service-user",fallbackFactory = UserFeignFallbackFactory.class)
public interface UserFeign extends UserApi {
    @Override
    @DeleteMapping(value = "deleteByPrimaryKey")
    ResultBean deleteByPrimaryKey(Integer id);

    @Override
    @PostMapping(value = "insert")
    ResultBean insert(User record);

    @Override
    @GetMapping(value = "selectByPrimaryKey")
    ResultBean selectByPrimaryKey(Integer id);

    @Override
    @GetMapping("selectAll")
    ResultBean selectAll();

    @Override
    @GetMapping(value = "updateByPrimaryKey")
    ResultBean updateByPrimaryKey(User record);

    @Override
    @GetMapping(value = "getByUserName")
    ResultBean getByUserName(String userName);
}
