package com.wyj.user.service.impl;

import com.wyj.user.entity.Permission;
import com.wyj.user.mapper.PermissionMapper;
import com.wyj.user.service.IPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wuyijie
 * @project mall
 * @className PermissionServiceImpl
 * @description TODO
 * @date 2020/11/7 23:42
 */
@Service
@Slf4j
public class PermissionServiceImpl implements IPermissionService {
    private PermissionMapper permissionMapper;

    @Autowired
    public void setPermissionMapper(PermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Permission record) {
        return 0;
    }

    @Override
    public Permission selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Permission> selectAll() {
        return null;
    }


    @Override
    public int updateByPrimaryKey(Permission record) {
        return 0;
    }
}
