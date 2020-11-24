package com.wyj.auth.aop;

import java.lang.annotation.*;

/**
 * @author wuyijie
 * @project irrigate
 * @className AccessLogAnnotation
 * @description TODO
 * @date 2020/9/9 09:55
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AccessLogAnnotation {
    String operationModule() default ""; // 操作模块
    String operationType() default "";  // 操作类型
    String operationDesc() default "";  // 操作说明
}
