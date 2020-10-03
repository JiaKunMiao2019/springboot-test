/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Application
 * Author:   莉莉
 * Date:     2020/7/28 10:58
 * Description: 启动类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cctv.ApplicationBotstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * 〈一句话功能简述〉<br> 
 * 〈启动类〉
 *
 * @author 莉莉
 * @create 2020/7/28
 * @since 1.0.0
 */
@SpringBootApplication(scanBasePackages = {"com.cctv"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}