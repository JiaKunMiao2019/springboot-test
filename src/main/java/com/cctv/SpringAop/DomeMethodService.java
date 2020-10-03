/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: DomeMethodService
 * Author:   莉莉
 * Date:     2020/7/28 11:21
 * Description: 方法类的拦截类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cctv.SpringAop;

import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈方法类的拦截类〉
 *
 * @author 莉莉
 * @create 2020/7/28
 * @since 1.0.0
 */
@Service
public class DomeMethodService {
    public String add(){
        return "方法类拦截的类";
    }
}