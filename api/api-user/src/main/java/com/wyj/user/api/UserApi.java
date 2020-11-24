package com.wyj.user.api;

import com.wyj.auth.entity.ResultBean;
import com.wyj.user.api.fallback.UserApiFallbackFactory;
import com.wyj.user.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author wuyijie
 * @project mall
 * @className UserApi
 * @description TODO
 * @date 2020/11/13 23:30
 */
public interface UserApi{

    ResultBean deleteByPrimaryKey(Integer id);


    ResultBean insert(User record);


    ResultBean selectByPrimaryKey(Integer id);


    ResultBean selectAll();


    ResultBean updateByPrimaryKey(User record);

    /**
     * @author wuyijie
     * @description TODO 根据用户名查询用户信息。
     * @methodName getByUserName
     * @param userName:
     * @return * @return: com.wyj.auth.entity.ResultBean
     * @date 2020/11/14 22:54
     */
    ResultBean getByUserName(String userName);




}
