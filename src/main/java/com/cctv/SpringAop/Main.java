/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Main
 * Author:   莉莉
 * Date:     2020/7/28 11:35
 * Description: 执行
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cctv.SpringAop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 〈一句话功能简述〉<br> 
 * 〈执行〉
 *
 * @author 莉莉
 * @create 2020/7/28
 * @since 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AopConfig.class);
        DemoAnnocationService bean1 = context.getBean(DemoAnnocationService.class);
        DomeMethodService bean2 = context.getBean(DomeMethodService.class);
        System.out.println(bean1.add());
        System.out.println(bean2.add());
    }
}