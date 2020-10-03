/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ProducerAndConcumer1
 * Author:   莉莉
 * Date:     2020/9/6 14:03
 * Description: 生产者与消费者
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cctv.SynchronizeAndLockCHeck;

import java.util.Random;

/**
 * 〈一句话功能简述〉<br> 
 * 〈生产者与消费者〉
 *
 * @author 莉莉
 * @create 2020/9/6
 * @since 1.0.0
 */
public class ProducerAndConcumer1 {
    public static void main(String[] args) throws InterruptedException {
        Container container = new Container();
        Producer producer = new Producer(container);
        Consumer consumer = new Consumer(container);

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }

    //锁对象
    static class Container {
        volatile Object velue;
    }

    //生产者---如果容器中没有值时执行
    static class Producer extends Thread {
        Container container;

        public Producer(Container container) {
            this.container = container;
        }

        @Override
        public void run() {
            synchronized (container) {
                while (container.velue != null) {
                    try {
                        container.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int row = new Random().nextInt();
                System.out.println("producing"+row);
                container.velue = row;
                container.notify();
            }
        }
    }

    //消费者---如果容器中有值时执行
    static class Consumer extends Thread{
        Container container;

        public Consumer(Container container){
            this.container = container;
        }
        @Override
        public void run(){
            synchronized (container) {
                while (container.velue == null) {
                    try {
                        container.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("producing"+container.velue);
                container.velue = null;
                container.notify();
            }
        }
    }
}