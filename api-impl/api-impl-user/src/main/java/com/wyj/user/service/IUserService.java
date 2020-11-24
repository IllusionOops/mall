package com.wyj.user.service;

import com.wyj.user.entity.User;

import java.util.List;

/**
 * @author wuyijie
 * @project mall
 * @className IUserService
 * @description TODO
 * @date 2020/11/7 23:29
 */

public interface IUserService {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User getByUserName(String userName);
}
