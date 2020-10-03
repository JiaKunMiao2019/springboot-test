/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ThreadCas
 * Author:   莉莉
 * Date:     2020/9/1 21:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cctv.ThreadUser;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 莉莉
 * @create 2020/9/1
 * @since 1.0.0
 */
public class ThreadCas {
    public synchronized void test1(){
        int i = 5;
        while (i-- > 0){
            System.out.println(Thread.currentThread().getName()+":"+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void test2(){
        synchronized (this){
            int i = 5;
            while (i-- > 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static synchronized void test3(){
        int i = 5;
        while (i-- > 0){
            System.out.println(Thread.currentThread().getName()+":"+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadCas cas = new ThreadCas();
        ThreadCas cas1 = new ThreadCas();
        ThreadCas cas2= new ThreadCas();
        ThreadCas cas3 = new ThreadCas();

        Thread thread1 = new Thread(() -> {cas.test2();});
        Thread thread2 = new Thread(() -> {ThreadCas.test3();});
        Thread thread3 = new Thread(() -> {cas1.test1();});
        Thread thread4 = new Thread(() -> {cas2.test1();});
        Thread thread5 = new Thread(() -> {cas3.test1();});

        thread1.start();
        thread2.start();
        thread3.start();
        //thread4.start();
        //thread5.start();
    }
}