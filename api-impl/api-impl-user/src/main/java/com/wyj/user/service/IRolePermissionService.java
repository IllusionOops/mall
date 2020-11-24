package com.wyj.user.service;

import com.wyj.user.entity.RolePermission;

import java.util.List;

/**
 * @author wuyijie
 * @project mall
 * @className IRolePermissionService
 * @description TODO
 * @date 2020/11/7 23:33
 */

public interface IRolePermissionService {
    int deleteByPrimaryKey(Integer id);

    int insert(RolePermission record);


    RolePermission selectByPrimaryKey(Integer id);


    List<RolePermission> selectAll();


    int updateByPrimaryKey(RolePermission record);
}
