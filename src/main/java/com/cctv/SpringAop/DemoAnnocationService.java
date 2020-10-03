/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: DemoAnnocationService
 * Author:   莉莉
 * Date:     2020/7/28 11:22
 * Description: 注解类的拦截
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cctv.SpringAop;

import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈注解类的拦截〉
 *
 * @author 莉莉
 * @create 2020/7/28
 * @since 1.0.0
 */
@Service
public class DemoAnnocationService {
    @Action(name = "注解类的拦截")
    public String add(){
        return "注解类的拦截";
    }
}