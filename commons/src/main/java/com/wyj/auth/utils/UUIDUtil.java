package com.wyj.auth.utils;

import java.util.UUID;

/**
 * @author wuyijie
 * @project mall
 * @className UUIDUtil
 * @description TODO
 * @date 2020/10/17 16:15
 */

public class UUIDUtil {

    public static String getUUIDCode(){
//        long nowTime=System.currentTimeMillis();
        UUID uuid=UUID.randomUUID();
        return uuid.toString().replaceAll("-","");
//        UUID.nameUUIDFromBytes("AAA".getBytes());
    }
}
