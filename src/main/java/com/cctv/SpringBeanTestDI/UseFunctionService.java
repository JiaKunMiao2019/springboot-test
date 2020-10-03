/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: UseFunctionService
 * Author:   莉莉
 * Date:     2020/7/28 10:52
 * Description: 使用不带注解的类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cctv.SpringBeanTestDI;

/**
 * 〈一句话功能简述〉<br> 
 * 〈使用不带注解的类〉
 *
 * @author 莉莉
 * @create 2020/7/28
 * @since 1.0.0
 */
public class UseFunctionService {
    FunctionService functionService;

    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }

    public String SayHello(String word){
        return functionService.sayHello(word);
    }
}