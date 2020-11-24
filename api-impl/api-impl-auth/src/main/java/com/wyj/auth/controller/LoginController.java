package com.wyj.auth.controller;

import com.wyj.auth.api.LoginApi;
import com.wyj.auth.entity.ResultBean;
import com.wyj.auth.feign.UserFeign;
import com.wyj.auth.util.ShiroMd5Util;
import com.wyj.user.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wuyijie
 * @project mall
 * @className LoginApi
 * @description TODO
 * @date 2020/11/13 23:00
 */
@RequestMapping("/auth")
@RestController
@Slf4j
public class LoginController implements LoginApi {
    private UserFeign userFeign;

    @Autowired
    public void setUserFeign(UserFeign userFeign) {
        this.userFeign = userFeign;
    }

    @Override
    @PostMapping(value = "/register")
    public ResultBean register(@RequestBody  User user) {
        ResultBean byUserName = userFeign.getByUserName(user.getUsername());
        if (null != byUserName.getData()){
            return new ResultBean(400,"用户名已存在",null);
        }else {
            user.setPassword(ShiroMd5Util.SysMd5(user));
            try {
                return new ResultBean(200,"添加用户成功",userFeign.insert(user));
            }catch (Exception e){
                log.error("logincontroller register => {}",e);
            }
        }
        return null;
    }

    @Override
    @GetMapping(value = "/login")
    public ResultBean login(@RequestParam("userName") String userName, @RequestParam("passWord") String passWord){
        return null;
    }

}
