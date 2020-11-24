package com.wyj.auth.util;

import com.wyj.user.entity.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @Author: wuxian
 * @Date: 2019/12/26 19:45
 */
public class ShiroMd5Util {

    /**
     * 添加用户密码加密,要与配置的密码匹配器对应
     *
     * @param user
     * @return
     */
    public static String SysMd5(User user) {
        String hashAlgorithmName = "MD5";//加密方式

        String password = user.getPassword(); //密码原值

        ByteSource bytes = ByteSource.Util.bytes(user.getUsername());

        int hashIterations = 5; //加密次数5

        SimpleHash simpleHash = new SimpleHash(hashAlgorithmName, password, bytes, hashIterations);

        return simpleHash.toString();
    }
}
