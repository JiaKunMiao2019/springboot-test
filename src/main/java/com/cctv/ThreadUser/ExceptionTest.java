/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ExceptionTest
 * Author:   莉莉
 * Date:     2020/9/3 14:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cctv.ThreadUser;

import java.io.IOException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 莉莉
 * @create 2020/9/3
 * @since 1.0.0
 */
public class ExceptionTest {
    public static void main(String[] args) throws InterruptedException {
        try {
            foo();
        }catch (Exception e){
            System.out.println("1");
        }finally {
            System.out.println("2");
        }
      //  Thread.sleep(100000000);
    }

    private static void foo() throws IOException {

    }
}