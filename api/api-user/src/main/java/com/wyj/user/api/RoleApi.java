package com.wyj.user.api;

import com.wyj.auth.entity.ResultBean;
import com.wyj.user.api.fallback.UserApiFallbackFactory;
import com.wyj.user.entity.Role;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author wuyijie
 * @project mall
 * @className RoleApi
 * @description TODO
 * @date 2020/11/13 23:42
 */

@RequestMapping("/roleApi")
public interface RoleApi {

    ResultBean deleteByPrimaryKey(Integer id);


    ResultBean insert(Role record);


    ResultBean selectByPrimaryKey(Integer id);


    ResultBean getAll();
    ResultBean getListByIds(@RequestParam("ids") String ids);


    ResultBean updateByPrimaryKey(Role record);
}
