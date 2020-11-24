package com.wyj.user.controller;

import com.wyj.auth.entity.ResultBean;
import com.wyj.user.api.RoleApi;
import com.wyj.user.entity.Role;
import com.wyj.user.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuyijie
 * @project mall
 * @className RoleController
 * @description TODO
 * @date 2020/11/13 23:50
 */

@RestController
@RequestMapping(value = "/roleController")
public class RoleController implements RoleApi {
    private IRoleService roleService;

    @Autowired
    public void setRoleService(IRoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public ResultBean deleteByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public ResultBean insert(Role record) {
        return null;
    }

    @Override
    public ResultBean selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public ResultBean getAll() {
        return null;
    }

    @Override
    @GetMapping("/getUserByUsernameAndPassWord")
    public ResultBean getListByIds(@RequestParam("ids") String ids) {
        return ResultBean.returnSelectSuccess(roleService.selectAllByIds(ids));
    }

    @Override
    public ResultBean updateByPrimaryKey(Role record) {
        return null;
    }
}
