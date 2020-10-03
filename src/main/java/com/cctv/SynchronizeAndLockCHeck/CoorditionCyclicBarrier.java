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

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * 〈一句话功能简述〉<br>
 * 〈生产者与消费者lock与condition〉
 *
 * @author 莉莉
 * @create 2020/9/6
 * @since 1.0.0
 */
public class CoorditionCyclicBarrier {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        CyclicBarrier latch = new CyclicBarrier(11);

        ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int value = new Random().nextInt();
                map.put(value, value);
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        latch.await();
        System.out.println(map);
    }

}