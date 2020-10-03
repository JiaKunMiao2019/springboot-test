/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ELConfig
 * Author:   莉莉
 * Date:     2020/7/28 16:17
 * Description: el的配置类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cctv.SpringEL;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

/**
 * 〈一句话功能简述〉<br> 
 * 〈el的配置类〉
 *
 * @author 莉莉
 * @create 2020/7/28
 * @since 1.0.0
 */
@Configuration
@ComponentScan("com.cctv.SpringEL")
@PropertySource("classpath:com.cctv.SpringEL/test.txt")
public class ELConfig {
    @Value("I Love You")//注入字符串
    private String normal;

    @Value("#{systemProperties['os.name']}")//获取系统信息
    private String osName;

    @Value("#(demoService.another)")//注入其他类的属性
    private String another;

    @Value("classpath:com.cctv.SpringEL/test.txt")//注入文件:这个是读取resource的下面的文件
    private Resource testFile;

    @Value("http://www.baidu.com")
    private Resource testUrl;

    @Value("${book.name}")
    private String name;

    @Autowired
    Environment environment;

    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource()throws Exception{
        System.out.println(normal);
        System.out.println(osName);
        System.out.println(another);
        System.out.println(IOUtils.toString(testFile.getInputStream()));
        System.out.println(IOUtils.toString(testUrl.getInputStream()));
        System.out.println(name);
        System.out.println(environment.getProperty("book.author"));
    }



}