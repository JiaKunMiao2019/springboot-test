/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: PrePostConfig
 * Author:   莉莉
 * Date:     2020/7/28 21:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cctv.BeanCreateAndDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 莉莉
 * @create 2020/7/28
 * @since 1.0.0
 */
@Configuration
@ComponentScan("com.cctv.BeanCreateAndDestroy")
public class PrePostConfig {
    @Bean(initMethod = "init",destroyMethod = "destroy")
    BeanWayService beanWayService(){
        return new BeanWayService();
    }

    @Bean
    JSR250WayService jsr250WayService(){
        return new JSR250WayService();
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("111", "1111");
        Collections.sort(list, Comparator.comparingInt(String::length));

    }
}