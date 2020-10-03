/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AnnocationConfig
 * Author:   莉莉
 * Date:     2020/7/28 10:29
 * Description: 一个项目的配置类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cctv.SpringAnnocationBeanTest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉<br> 
 * 〈一个项目的配置类〉
 *
 * @author 莉莉
 * @create 2020/7/28
 * @since 1.0.0
 */

/**
 * configuration的类由普通类型转变为cglib动态代理类，生成cglib动态代理对象，
 * 由拦截器进行拦截，处理bean的依赖关系
 */
@Configuration
@ComponentScan("com.cctv")
public class AnnocationConfig {

}