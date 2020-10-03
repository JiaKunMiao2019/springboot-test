/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AspectService
 * Author:   莉莉
 * Date:     2020/7/28 11:23
 * Description: 编写aop的拦截
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cctv.SpringAop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 〈一句话功能简述〉<br> 
 * 〈编写aop的拦截〉
 *
 * @author 莉莉
 * @create 2020/7/28
 * @since 1.0.0"
 */
@Aspect
@Component
public class AspectService {
    @Pointcut("@annotation(com.cctv.SpringAop.Action)")
    public void annocatonPointCut(){}

    //必须配置到方法上的拦截
    @Pointcut("execution(* com.cctv.SpringAop.*.*(..))")
    public void methoPointCut(){
    }

    @After("annocatonPointCut()")
    public void after(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action annotation = method.getAnnotation(Action.class);
        System.out.println("注解拦截" + annotation.name());
    }

    @Before("methoPointCut()")
    public void before(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法式拦截" + method.getName());
    }

    @Around("annocatonPointCut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知开始");
        proceedingJoinPoint.proceed();
        System.out.println("环绕通知结束");
    }
}