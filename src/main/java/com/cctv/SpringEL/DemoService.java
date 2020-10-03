/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: DemoService
 * Author:   莉莉
 * Date:     2020/7/28 16:07
 * Description: value注解添加的元素
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cctv.SpringEL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈value注解添加的元素〉
 *
 * @author 莉莉
 * @create 2020/7/28
 * @since 1.0.0
 */
@Service
public class DemoService {
    @Value("其他类型的属性")
    private String another;

    public String getAnother() {
        return another;
    }

    public void setAnother(String another) {
        this.another = another;
    }
}