/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: CharStringSafe
 * Author:   莉莉
 * Date:     2020/9/4 11:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cctv.SafeTestUser;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 莉莉
 * @create 2020/9/4
 * @since 1.0.0
 */
public class CharStringSafe {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(1);
        System.out.println(stringBuilder.toString());
        HashSet<Object> objects = new HashSet<>();
        objects.add(1);
        objects.add(1);
        objects.add(1);
        Integer integer = new Integer(1);
        System.out.println(objects.toString());
    }

}