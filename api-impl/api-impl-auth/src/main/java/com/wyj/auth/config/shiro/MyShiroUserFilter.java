package com.wyj.auth.config.shiro;

import com.alibaba.fastjson.JSON;
import com.wyj.auth.entity.ResultBean;
import org.apache.shiro.web.filter.authc.UserFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author: wuxian
 * @date: 2020/1/16 13:59
 */
public class MyShiroUserFilter extends UserFilter {
    @Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().write(JSON.toJSONString(new ResultBean(401,"用户未登陆，请先登录",null)));
    }

}
