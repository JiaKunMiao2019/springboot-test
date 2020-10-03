/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Threaduser
 * Author:   莉莉
 * Date:     2020/8/30 10:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cctv.ThreadUser;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 莉莉
 * @create 2020/8/30
 * @since 1.0.0
 */
public class Threaduser {
    private static int i=0;
    static Object lock1 = new Object();
    static Object lock2 = new Object();
    public static  void main(String[] args) throws InterruptedException {
        new Thread(()->{
            synchronized (lock1){
                try {
                    Thread.sleep(1000);
                    synchronized (lock2){
                        System.out.println("1");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        synchronized (lock2){
            Thread.sleep(1000);
            synchronized (lock1){
                System.out.println("2");
            }
        }
//
//        for (int j = 0; j < 1000; j++) {
//            new Thread(()->{
//                doSomeThing();
//            }).start();
//        }
//        System.out.println(i);
    }

    private static void doSomeThing() {
        i++;
    }

}