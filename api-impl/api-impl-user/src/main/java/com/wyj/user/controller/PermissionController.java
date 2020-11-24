package com.wyj.user.controller;

import com.wyj.auth.entity.ResultBean;
import com.wyj.user.api.PermissionApi;
import com.wyj.user.mapper.PermissionMapper;
import com.wyj.user.service.IPermissionService;
import com.wyj.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuyijie
 * @project mall
 * @className PermissionController
 * @description TODO
 * @date 2020/11/13 23:50
 */

@RestController
@RequestMapping(value = "/permissionController")
public class PermissionController implements PermissionApi {
    private IPermissionService permissionService;

    @Autowired
    public void setPermissionService(IPermissionService permissionService) {
        this.permissionService = permissionService;
    }

}
