package com.wyj.auth.config.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wuxian
 * @date 2019/12/23 14:21
 */
@Configuration
@Slf4j
public class ShiroConfig {
//    @Value("${shiro-redis.host}")
    private String redisClusterNodes="127.0.0.1:6379";
//    @Value("${shiro-redis.password}")
    private String redisClusterPassword="141535";
//    @Value("${shiro-redis.time-out}")
    private int redisClusterTimeOut=3000;

    /**
     * 注入 Shiro 过滤器
     * @param securityManager 安全管理器
     * @return ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        // 定义 shiroFactoryBean
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();

        // 设置自定义的 securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

//        // 设置默认登录的 URL，身份认证失败会访问该 URL
//        shiroFilterFactoryBean.setLoginUrl("/login");
//        // 设置成功之后要跳转的链接
//        shiroFilterFactoryBean.setSuccessUrl("/success");
        // 设置未授权界面，权限认证失败会访问该 URL
//        shiroFilterFactoryBean.setUnauthorizedUrl("http://localhost:9000/user/error");
        Map<String, Filter> filters = shiroFilterFactoryBean.getFilters();
        filters.put("authc",new MyShiroUserFilter());
        // LinkedHashMap 是有序的，进行顺序拦截器配置
        Map<String,String> filterChainMap = new LinkedHashMap<>();

        // 配置可以匿名访问的地址，可以根据实际情况自己添加，放行一些静态资源等，anon 表示放行
        filterChainMap.put("/css/**", "anon");
        filterChainMap.put("/imgs/**", "anon");
        filterChainMap.put("/js/**", "anon");
        filterChainMap.put("/swagger-*/**", "anon");

        filterChainMap.put("/swagger-resources/**", "anon");
        filterChainMap.put("/v2/api-docs", "anon");
        filterChainMap.put("/webjars/springfox-swagger-ui/**", "anon");
//        filterChainMap.put("/swagger-ui.html/**", "anon");

        filterChainMap.put("/user/getUserPressionByName","anon");
        filterChainMap.put("/ user/getUserRolesByName","anon");
        // 登录 URL 放行
        filterChainMap.put("/auth/login", "anon");
        // 配置 logout 过滤器
        filterChainMap.put("/auth/logout", "anon");

        filterChainMap.put("/auth/register","anon");

        filterChainMap.put("/**", "authc");


        // 设置 shiroFilterFactoryBean 的 FilterChainDefinitionMap
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
        log.info("====shiroFilterFactoryBean注册完成====");
        return shiroFilterFactoryBean;
    }


    /**
     * 注入自定义的 Realm
     * @return MyRealm
     */
    @Bean
    public MyRelam myAuthRealm() {
        MyRelam myRelam = new MyRelam();
        myRelam.setCredentialsMatcher(credentialsMatcher());
        log.info("====myRealm注册完成=====");
        return myRelam;
    }


    /**
     * 注入安全管理器
     * @return SecurityManager
     */
    @Bean
    public SecurityManager securityManager() {
        // 将自定义 Realm 加进来
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myAuthRealm());
        securityManager.setSessionManager(defaultWebSessionManager());
        securityManager.setCacheManager(cacheManager());
        securityManager.setRememberMeManager(rememberMeManager());
        log.info("====securityManager注册完成====");
        return securityManager;
    }
    
    /** 
     * @author wuyijie
     * @description TODO  https://blog.csdn.net/qq_16962599/article/details/82023806 shiro配置外部redis无法读取配置文件数据。
     * @methodName getLifecycleBeanPostProcessor
     * @param 
     * @return * @return: org.apache.shiro.spring.LifecycleBeanPostProcessor
     * @date 2020/11/16 19:39
     */
    @Bean
    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
    /**
     * 配置shiro redisManager
     * 网上的一个 shiro-redis 插件，实现了shiro的cache接口、CacheManager接口
     * @return
     */
    @Bean
    public RedisManager redisManager(){
        RedisManager redisManager = new RedisManager();
        System.out.println("redisClusterNodes="+redisClusterNodes);
        redisManager.setHost(redisClusterNodes);
        redisManager.setPassword(redisClusterPassword);
        redisManager.setTimeout(redisClusterTimeOut);
        return redisManager;
    }

    /**
     * RedisSessionDAO shiro sessionDao层的实现 通过redis
     */
    @Bean
    public RedisSessionDAO redisSessionDAO(){
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        //session在redis中的保存时间,最好大于session会话超时时间
        redisSessionDAO.setExpire(18000);
        return redisSessionDAO;
    }

    @Bean
    public DefaultWebSessionManager defaultWebSessionManager(){
        DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();
        defaultWebSessionManager.setSessionDAO(redisSessionDAO());
        return defaultWebSessionManager;
    }

    @Bean(name = "redisCacheManager")
    public RedisCacheManager cacheManager(){
        RedisCacheManager cacheManager = new RedisCacheManager();
        cacheManager.setRedisManager(redisManager());
        //用户权限信息缓存时间
        cacheManager.setExpire(redisClusterTimeOut);
        return cacheManager;
    }

    @Bean
    public SimpleCookie rememberMeCookie(){
        log.info("ShiroConfig.rememberMeCookie()");
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
        simpleCookie.setMaxAge(259200);
        simpleCookie.setHttpOnly(true);
        return simpleCookie;
    }
    /**
     * cookie管理对象;
     * @return
     */
    @Bean
    public CookieRememberMeManager rememberMeManager(){

        System.out.println("ShiroConfiguration.rememberMeManager()");
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        // cookieRememberMeManager.setCipherKey(org.apache.shiro.codec.Base64.decode("6ZmI6I2j5Y+R5aSn5ZOlAA=="));
        cookieRememberMeManager.setCookie(rememberMeCookie());
        return cookieRememberMeManager;
    }

    /**
     * 密码匹配
     * @return
     */
    @Bean
    public HashedCredentialsMatcher credentialsMatcher(){
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("md5");
        credentialsMatcher.setHashSalted(true);
        credentialsMatcher.setHashIterations(5);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }


    //自动创建代理，没有这个鉴权可能会出错
    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
        defaultAAP.setProxyTargetClass(true);
        return defaultAAP;
    }

    /**
     * 开启shiro aop注解支持.
     * 使用代理方式;所以需要开启代码支持;
     *
     * @param
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * 配置Shiro生命周期处理器
     * @return
     */
    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
}
