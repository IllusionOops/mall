package com.wyj.user.service;

import com.wyj.user.entity.Permission;

import java.util.List;

/**
 * @author wuyijie
 * @project mall
 * @className IPErmissionService
 * @description TODO
 * @date 2020/11/7 23:32
 */

public interface IPermissionService {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    Permission selectByPrimaryKey(Integer id);

    List<Permission> selectAll();

    int updateByPrimaryKey(Permission record);
}
