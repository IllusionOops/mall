package com.wyj.user.controller;

import com.wyj.auth.entity.ResultBean;
import com.wyj.user.api.UserApi;
import com.wyj.user.entity.User;
import com.wyj.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wuyijie
 * @project mall
 * @className UserController
 * @description TODO
 * @date 2020/11/7 23:43
 */
@RestController
//@RequestMapping(value = "/userController")
public class UserController implements UserApi {
    private IUserService userService;

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getByUserName")
    public ResultBean getUserByUsername(@RequestParam("userName") String userName){
        return ResultBean.returnSelectSuccess(userService.getByUserName(userName));
    }


    @Override
    public ResultBean deleteByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public ResultBean insert(User record) {
        return null;
    }

    @Override
    public ResultBean selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public ResultBean selectAll() {
        return null;
    }

    @Override
    public ResultBean updateByPrimaryKey(User record) {
        return null;
    }

    @Override
    public ResultBean getByUserName(String userName) {
        return null;
    }
}
