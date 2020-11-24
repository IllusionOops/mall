package com.wyj.user.service.impl;

import com.wyj.user.entity.Role;
import com.wyj.user.mapper.RoleMapper;
import com.wyj.user.service.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wuyijie
 * @project mall
 * @className RoleServiceImpl
 * @description TODO
 * @date 2020/11/7 23:41
 */
@Service
@Slf4j
public class RoleServiceImpl implements IRoleService {
    private RoleMapper roleMapper;

    @Autowired
    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Role record) {
        return 0;
    }

    @Override
    public Role selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Role> selectAll() {
        return null;
    }

    @Override
    public List<Role> selectAllByIds(String ids) {
        return roleMapper.selectAllByIds(ids);
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return 0;
    }
}
