package com.wyj.user.service;

import com.wyj.user.entity.UserRole;

import java.util.List;

/**
 * @author wuyijie
 * @project mall
 * @className IUserRoleService
 * @description TODO
 * @date 2020/11/7 23:31
 */

public interface IUserRoleService {

    int deleteByPrimaryKey(Integer id);


    int insert(UserRole record);


    UserRole selectByPrimaryKey(Integer id);


    List<UserRole> selectAll();


    int updateByPrimaryKey(UserRole record);
}
