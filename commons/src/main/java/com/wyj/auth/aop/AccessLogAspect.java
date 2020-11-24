package com.wyj.auth.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author wuyijie
 * @project irrigate
 * @className AccessLogAspect
 * @description TODO 访问日志切面类，定义切入点和通知。
 * @date 2020/9/9 10:14
 */
@Aspect
@Component
@Slf4j
public class AccessLogAspect {
//
//    @Autowired
//    private SysAccesslogMapper sysAccesslogMapper;
//    /**
//     * @author wuyijie
//     * @description TODO  设置访问日志的切入点。两种方式：注解方式切入、扫描包
//     * @methodName accessLogPointCut
//     * @return * @return: void
//     * @date 2020/9/9 10:23
//     */
//    @Pointcut("@annotation(com.elitel.irr.aop.AccessLogAnnotation)")
//    public void accessLogPointCut(){}
//
//    @Around(value ="accessLogPointCut()")
//    public ResultBean saveAccessLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        ResultBean resultBean=new ResultBean();
//        // 获取RequestAttributes
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        // 从获取RequestAttributes中获取HttpServletRequest的信息
//        HttpServletRequest httpServletRequest = (HttpServletRequest) requestAttributes
//                .resolveReference(RequestAttributes.REFERENCE_REQUEST);
//
//        SysAccesslog accessLog = new SysAccesslog();
////        accessLog.setId(CodeUtil.getUUIDCode());
////        从切面织入处通过反射机制获取织入点处的方法
//        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
//        //获取切入点所在的方法。
//        Method method = signature.getMethod();
//        AccessLogAnnotation annotation = method.getAnnotation(AccessLogAnnotation.class);
//        accessLog.setModual(annotation.operationModule());
//        accessLog.setType(annotation.operationType());
//        accessLog.setDesc(annotation.operationDesc());
//
//        //请求的类名
//        String className = proceedingJoinPoint.getTarget().getClass().getName();
//        //请求的方法名
//        String methodName = method.getName();
//
//        accessLog.setMethod(className + "." + methodName);
//
//        //请求的参数
////        Map<String, String> requestParamMap = converMap(httpServletRequest.getParameterMap());
//        //将参数所在的数组转换json
////        JSONObject jsonObject = JSONObject.fromObject(requestParamMap);
////        accessLog.setParams(jsonObject.toString());
//
//        accessLog.setUserid("");
//        accessLog.setUserip(IpUtil.getRemoteIp(httpServletRequest));
////        accessLog.setLocalIp(IpUtil.getLocalIp());
//        accessLog.setUri(httpServletRequest.getRequestURI());
//        accessLog.setCreatetime(new Date());
//        accessLog.setDoexlog(0);
//
//        //开始调用时间
//        long start = System.currentTimeMillis();
//
//        //调用service保存SysLog实体类到数据库
//        //sysLogService.save(sysLog);
//        try {
//            // 执行目标方法
//            resultBean = (ResultBean) proceedingJoinPoint.proceed();
//            if (resultBean.getCode()!= 200){
//                //目标方法跑出异常----异常通知
//                accessLog.setDoexlog(1);
//            }
//            //方法执行后----
////            accessLog.setResponse(resultBean.getData().toString());
//        } catch (Throwable throwable) {
//            LOGGER.error("环绕通知失败:",throwable);
//            throwable.printStackTrace();
//        }finally {
//            Long time = System.currentTimeMillis() - start;
//            accessLog.setTotaltime(time);
//            sysAccesslogMapper.insert(accessLog);
////            rmqProducer.send(JSON.toJSONString(accessLog),logRMQExchangeName,logRMQRoutingKey);
////            log.info("最终通知执行···");
//        }
//        return resultBean;
//    }
//
//
//    /**
//     * @author wuyijie
//     * @description TODO  转换请求参数
//     * @methodName converMap
//     * @param paramMap:  request获取的参数数组
//     * @return * @return: java.util.Map<java.lang.String,java.lang.String>
//     * @date 2020/9/9 11:09
//     */
//    public Map<String, String> converMap(Map<String, String[]> paramMap) {
//        Map<String, String> rtnMap = new HashMap<String, String>();
//        for (String key : paramMap.keySet()) {
//            rtnMap.put(key, paramMap.get(key)[0]);
//        }
//        return rtnMap;
//    }
//
//    /**
//     * @author wuyijie
//     * @description TODO  转换异常信息为字符串
//     * @methodName stackTraceToString
//     * @param exceptionName: 异常名称
//     * @param exceptionMessage: 异常信息
//     * @param elements: 堆栈信息
//     * @return * @return: java.lang.String
//     * @date 2020/9/9 11:09
//     */
//    public String stackTraceToString(String exceptionName, String exceptionMessage, StackTraceElement[] elements) {
//        StringBuffer strbuff = new StringBuffer();
//        for (StackTraceElement stet : elements) {
//            strbuff.append(stet + "\n");
//        }
//        String message = exceptionName + ":" + exceptionMessage + "\n\t" + strbuff.toString();
//        return message;
//    }

}
