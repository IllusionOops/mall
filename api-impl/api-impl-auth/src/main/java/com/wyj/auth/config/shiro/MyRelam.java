package com.wyj.auth.config.shiro;

import com.wyj.auth.entity.ResultBean;
import com.wyj.auth.feign.UserFeign;
import com.wyj.user.entity.Permission;
import com.wyj.user.entity.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wuxian
 * @date 2019/12/23 14:21
 */
public class MyRelam extends AuthorizingRealm {

    @Autowired
    private UserFeign userFeign;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        String userName = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //获取数据库用户角色
        ResultBean byUserName = userFeign.getByUserName(userName);
        User user = (User)byUserName.getData();
        List<String> roleStrList = new LinkedList<>();
        roleStrList.add(user.getRole().getRole());
        if (!CollectionUtils.isEmpty(roleStrList)){
            authorizationInfo.addRoles(roleStrList);
        }
        //获取数据库用户权限
        List<String> permissionStrList = new LinkedList<>();
        List<Permission> permissionList = user.getRole().getPermissionList();
        permissionList.forEach(permission -> permissionStrList.add(permission.getName()));
        if (!CollectionUtils.isEmpty(permissionStrList)){
            authorizationInfo.addStringPermissions(permissionStrList);
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //根据token获取用户名
        String username = (String) token.getPrincipal();

        User user =(User) userFeign.getByUserName(username).getData();
        if (user == null){
            throw new AuthenticationException("此用户不存在");
        } else {
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
            simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(user.getUsername()));
            return simpleAuthenticationInfo;
        }
    }
}
