package com.wyj.user.service.impl;

import com.wyj.user.entity.UserRole;
import com.wyj.user.service.IUserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wuyijie
 * @project mall
 * @className UserRoleServiceImpl
 * @description TODO
 * @date 2020/11/7 23:40
 */
@Service
@Slf4j
public class UserRoleServiceImpl implements IUserRoleService {
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(UserRole record) {
        return 0;
    }

    @Override
    public UserRole selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<UserRole> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(UserRole record) {
        return 0;
    }
}
