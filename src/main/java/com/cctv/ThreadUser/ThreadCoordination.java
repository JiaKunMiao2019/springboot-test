/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ThreadCoordination
 * Author:   莉莉
 * Date:     2020/9/6 15:50
 * Description: 多线程协同
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cctv.ThreadUser;

import java.util.concurrent.Executor;

/**
 * 〈一句话功能简述〉<br> 
 * 〈多线程协同〉
 *
 * @author 莉莉
 * @create 2020/9/6
 * @since 1.0.0
 */
public class ThreadCoordination {
    public static void main(String[] args) {
        new MyThread().execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+1111);
            }
        });
        new MyThread().execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+2222);
            }
        });
    }

   static class MyThread implements Executor{
        @Override
        public void execute(Runnable command) {
            new Thread(command).start();
        }
    }

}