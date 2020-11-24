package com.wyj.user.service.impl;

import com.wyj.user.entity.RolePermission;
import com.wyj.user.service.IRolePermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wuyijie
 * @project mall
 * @className RolePermissionServiceImpl
 * @description TODO
 * @date 2020/11/7 23:42
 */
@Service
@Slf4j
public class RolePermissionServiceImpl implements IRolePermissionService {
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(RolePermission record) {
        return 0;
    }

    @Override
    public RolePermission selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<RolePermission> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(RolePermission record) {
        return 0;
    }
}
