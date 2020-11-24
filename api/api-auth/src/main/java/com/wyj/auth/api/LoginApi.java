package com.wyj.auth.api;

import com.wyj.auth.entity.ResultBean;
import com.wyj.user.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wuyijie
 * @project mall
 * @className LoginApi
 * @description TODO
 * @date 2020/11/8 18:29
 */

public interface LoginApi {

    ResultBean register(@RequestBody User user);

    /**
     * @author wuyijie
     * @description TODO 通过用户名和账号登录
     * @methodName login
     * @param userName:
     * @param passWord:
     * @return * @return: com.wyj.entity.ResultBean
     * @date 2020/11/8 18:34
     */
    ResultBean login(@RequestParam("userName") String userName, @RequestParam("passWord") String passWord);


}
