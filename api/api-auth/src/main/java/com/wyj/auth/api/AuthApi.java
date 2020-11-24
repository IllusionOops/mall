package com.wyj.auth.api;

import com.wyj.auth.entity.ResultBean;
import com.wyj.auth.hystrix.UserServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wuyijie
 * @project mall
 * @className AuthApi
 * @description TODO
 * @date 2020/11/8 14:19
 */
public interface AuthApi {
    /**
     * 根据Token，判断是否登录
     * @return
     */
    @RequestMapping(value="/checkLogin", method= RequestMethod.POST)
    ResultBean checkLogin();

    @RequestMapping(value="/getUserInfo", method=RequestMethod.POST)
    ResultBean getUserInfo(HttpServletRequest request, String cookie);

    /**
     * 根据请求url，判断是否有权限
     * 需要先判断是否登录
     * 未配置权限码的接口，默认放行；后续在数据库添加控制字段
     * 这里的参数名称，不能叫token，碰到过冲突的场景
     * @return
     */
    @RequestMapping(value="/checkPermission", method=RequestMethod.POST)
    ResultBean checkPermission(@RequestParam("cookie")String cookie, @RequestParam("checkUrl")String checkUrl);


    @RequestMapping(value="/getPermission", method=RequestMethod.POST)
    ResultBean getPermission(@RequestParam("module")String module, @RequestParam("userEntity")String userEntity);

    Object refreshPermission(String module);

}
