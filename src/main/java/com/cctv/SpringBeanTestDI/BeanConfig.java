/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: BeanConfig
 * Author:   莉莉
 * Date:     2020/7/28 10:54
 * Description: 为不带注解的类添加依赖关系
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cctv.SpringBeanTestDI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉<br> 
 * 〈为不带注解的类添加依赖关系〉
 *
 * @author 莉莉
 * @create 2020/7/28
 * @since 1.0.0
 */
@Configuration
public class BeanConfig {
    @Bean(name = "functionServiceOne")
    public FunctionService functionService(){
        return new FunctionService();
    }

    @Bean(name = "useFunctionServiceTwo")
    public UseFunctionService useFunctionService(FunctionService functionService){
        UseFunctionService useFunctionService = new UseFunctionService();
        useFunctionService.setFunctionService(functionService);
        return useFunctionService;
    }
}