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
import java.util.Random;
import java.util.concurrent.*;
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
public class ProducerAndConcumer4 {

    //首先新建一个锁Exchanger
    private static Exchanger exchanger = new Exchanger();

    public static void main(String[] args) throws InterruptedException {
        Producer producer = new Producer(exchanger);
        Concumer concumer = new Concumer(exchanger);

        producer.start();
        concumer.start();

        producer.join();
        concumer.join();
    }

    static class Producer extends Thread {
        Exchanger<Integer> exchanger;

        public Producer(Exchanger exchanger) {
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            try {
                exchanger.exchange(1111);
                System.out.println("Producer:");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class Concumer extends Thread {
        Exchanger<Integer> exchanger;

        public Concumer(Exchanger exchanger) {
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            try {
                System.out.println("Concumer:"+exchanger.exchange(null));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}