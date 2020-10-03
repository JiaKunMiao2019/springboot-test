/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ThreadCoordination
 * Author:   莉莉
 * Date:     2020/9/6 14:26
 * Description: 多线程协同问题
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cctv.SynchronizeAndLockCHeck;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈一句话功能简述〉<br> 
 * 〈多线程协同问题〉
 *
 * @author 莉莉
 * @create 2020/9/6
 * @since 1.0.0
 */
public class ThreadCoordination {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        AtomicInteger haveManyThreadRunning = new AtomicInteger(10);

        ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int value = new Random().nextInt();
                map.put(value,value);
                lock.lock();
                try {
                    haveManyThreadRunning.decrementAndGet();
                    condition.signal();
                }finally {
                    lock.unlock();
                }
            }).start();
        }

        lock.lock();

        try {
            while (haveManyThreadRunning.get() > 0){
                condition.await();
                System.out.println("线程没有终止");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("释放锁");
            lock.unlock();
        }
        System.out.println(map);
    }

}