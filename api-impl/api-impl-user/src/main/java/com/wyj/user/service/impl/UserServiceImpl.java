package com.wyj.user.service.impl;

import com.wyj.user.entity.Permission;
import com.wyj.user.entity.User;
import com.wyj.user.mapper.PermissionMapper;
import com.wyj.user.mapper.UserMapper;
import com.wyj.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wuyijie
 * @project mall
 * @className UserServiceImpl
 * @description TODO
 * @date 2020/11/7 23:37
 */
@Service
@Slf4j
public class UserServiceImpl implements IUserService {
    private UserMapper userMapper;
    private PermissionMapper permissionMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setPermissionMapper(PermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(User record) {
        try {
            return userMapper.insert(record);
        } catch (Exception e) {
            log.error("useserviceimpl insert =>{}", e);
        }

        return 0;
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<User> selectAll() {
        return null;
    }


    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }

    @Override
    public User getByUserName(String userName) {
        try {
            User user = userMapper.selectByUserName(userName);
            if (null != user && null != user.getRole()) {
                Integer roleId = user.getRole().getId();
                List<Permission> permissions = permissionMapper.selectByRoleId(roleId);
                user.getRole().setPermissionList(permissions);
            }
            return user;
        } catch (Exception e) {
            log.error("UserServiceImpl.getByUserName  error=>{}", e);
        }
        return null;
    }
}
