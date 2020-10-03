/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: FunctionService
 * Author:   莉莉
 * Date:     2020/7/28 10:25
 * Description: 一个简单的交给spring容器管理的class
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cctv.SpringAnnocationBeanTest;

import org.springframework.stereotype.Service;

/**
 * 〈一个简单的交给spring容器管理的class〉
 *
 * @author 莉莉
 * @create 2020/7/28
 * @since 1.0.0
 */
@Service("functionServiceTwo")
public class FunctionService {
    public String sayHello(String word){
        return "Hello " + word + " !";
    }
}