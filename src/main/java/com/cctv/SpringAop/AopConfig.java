/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AopConfig
 * Author:   莉莉
 * Date:     2020/7/28 11:34
 * Description: aop的使用注解
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cctv.SpringAop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 〈一句话功能简述〉<br> 
 * 〈aop的使用注解〉
 *
 * @author 莉莉
 * @create 2020/7/28
 * @since 1.0.0
 */
@Configuration
@ComponentScan("com.cctv.SpringAop")
@EnableAspectJAutoProxy
public class AopConfig {

}