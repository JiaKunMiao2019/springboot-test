/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ProducerAndConcumer2
 * Author:   莉莉
 * Date:     2020/9/6 14:07
 * Description: 生产者与消费者lock与condition
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cctv.SynchronizeAndLockCHeck;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈一句话功能简述〉<br>
 * 〈生产者与消费者lock与condition〉
 *
 * @author 莉莉
 * @create 2020/9/6
 * @since 1.0.0
 */
public class ProducerAndConcumer3 {
    //信号量
    static Semaphore emptySema = new Semaphore(1);
    static Semaphore fullSema = new Semaphore(1);

    //定义一个最大队列
    private static final int MAX_SIZE_QUEUE = 100;

    //首先新建一个锁Lock,最常用的锁reentrantlock
    private static Lock lock = new ReentrantLock();

    //condition的条件
    private static Condition empty = lock.newCondition();
    private static Condition full = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> queue = new LinkedList<>();
        Producer producer = new Producer(queue);
        Concumer concumer = new Concumer(queue);


            producer.start();
            concumer.start();

            producer.join();
            concumer.join();


    }

    static class Producer extends Thread {
        Queue<Integer> queue;

        public Producer(Queue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
              emptySema.acquire();
              synchronized (ProducerAndConcumer3.class){
                  System.out.println("Producing");
                  queue.add(123);
                  fullSema.release();
              }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class Concumer extends Thread {
        Queue<Integer> queue;

        public Concumer(Queue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
              fullSema.acquire();
              synchronized (ProducerAndConcumer3.class){
                  System.out.println("Comcumer:"+queue.remove());
              }
              emptySema.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}