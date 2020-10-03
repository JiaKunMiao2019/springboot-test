/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: JSR250WayService
 * Author:   莉莉
 * Date:     2020/7/28 21:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cctv.BeanCreateAndDestroy;

import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 莉莉
 * @create 2020/7/28
 * @since 1.0.0
 */
public class JSR250WayService {
    @PostConstruct//构造函数执行完之后执行
    public void init(){
        System.out.println("jsr250-init-method");
    }

    public JSR250WayService() {
        super();
        System.out.println("jsr250WayService");
    }

    @PreDestroy//在bean销毁之前执行
    public void destroy(){
        System.out.println("jsr250-destroy-method");
    }

    public static void main(String[] args) {
        int index = 1;
        for (int i = 0; i < 5; i++) {
            index += index;
            System.out.println(index);

        }
        System.out.println(index);
    }
}