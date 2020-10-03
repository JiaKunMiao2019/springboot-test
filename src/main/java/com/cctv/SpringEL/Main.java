/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Mai
 * Author:   莉莉
 * Date:     2020/7/28 16:59
 * Description: 启动
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cctv.SpringEL;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 〈一句话功能简述〉<br> 
 * 〈启动〉
 *
 * @author 莉莉
 * @create 2020/7/28
 * @since 1.0.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ELConfig.class);
        ELConfig bean = context.getBean(ELConfig.class);
        bean.outputResource();
        context.close();
    }
}