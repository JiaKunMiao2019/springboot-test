/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: UseFunctionService
 * Author:   莉莉
 * Date:     2020/7/28 10:27
 * Description: 调用其他Service的注入使用
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cctv.SpringAnnocationBeanTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈调用其他Service的注入使用〉
 *
 * @author 莉莉
 * @create 2020/7/28
 * @since 1.0.0
 */

/**
 * spring的注解使用，在一个类中使用spring的注解，这个类首先也是交给spring容器管理的
 * 类，如果不是交给spring容器管理的类，在初始的过程中无法联系上线文导致出现错误
 */
@Service
public class UseFunctionService {
    @Autowired
    FunctionService functionService;

    public String SayHello(String word){
        return  functionService.sayHello(word);
    }
}