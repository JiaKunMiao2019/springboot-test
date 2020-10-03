/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Main
 * Author:   莉莉
 * Date:     2020/7/28 10:56
 * Description: 执行类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cctv.SpringBeanTestDI;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 〈一句话功能简述〉<br> 
 * 〈执行类〉
 *
 * @author 莉莉
 * @create 2020/7/28
 * @since 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        UseFunctionService bean = context.getBean(UseFunctionService.class);
        System.out.println(bean.SayHello("beanCofig"));
    }
}