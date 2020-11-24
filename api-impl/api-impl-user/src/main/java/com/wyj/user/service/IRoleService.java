package com.wyj.user.service;

import com.wyj.user.entity.Role;

import java.util.List;

/**
 * @author wuyijie
 * @project mall
 * @className IRoleService
 * @description TODO
 * @date 2020/11/7 23:32
 */

public interface IRoleService {

    int deleteByPrimaryKey(Integer id);


    int insert(Role record);


    Role selectByPrimaryKey(Integer id);


    List<Role> selectAll();
    List<Role> selectAllByIds(String ids);


    int updateByPrimaryKey(Role record);
}
