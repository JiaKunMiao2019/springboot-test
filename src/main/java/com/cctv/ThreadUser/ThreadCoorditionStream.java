/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ThreadCoorditionStream
 * Author:   莉莉
 * Date:     2020/9/6 15:55
 * Description: 对线程读取stream的方法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cctv.ThreadUser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈对线程读取stream的方法〉
 *
 * @author 莉莉
 * @create 2020/9/6
 * @since 1.0.0
 */
public class ThreadCoorditionStream {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<File> files = Arrays.asList(
                new File("1"),
                new File("2"),
                new File("3"));

        ExecutorService threadPool = new ThreadPoolExecutor(3,3,60,TimeUnit.SECONDS,
                new LinkedBlockingDeque<>());
                //Executors.newFixedThreadPool(3);//创建线程池

        ArrayList<Future<Map<String,Integer>>> futureList = new ArrayList<>();
        for (File file: files) {
            Future<Map<String, Integer>> future = threadPool.submit(new WorkCount(file));
            System.out.println("Get future get():"+file);
            futureList.add(future);
        }

        HashMap<String, Integer> resultMap = new HashMap<>();
        for (Future<Map<String,Integer>> future: futureList) {
            Map<String, Integer> result = future.get();
          //  System.out.println(result);
            //把result合并到resultMap中
            for (Map.Entry<String, Integer> map: result.entrySet()){
                int count = 0;
                if (null != resultMap.get(map.getKey())){
                 count = resultMap.get(map.getKey()) + map.getValue();
                }else{
                    count = map.getValue();
                }
                resultMap.put(map.getKey(),count);
            }
        }
        System.out.println(resultMap);

        threadPool.shutdown();
    }

    static class WorkCount implements Callable<Map<String,Integer>>{
        File file;

        public WorkCount(File file){
            this.file = file;
        }
        @Override
        public Map<String, Integer> call() throws Exception {

            return count(file);
        }
    }

    public static Map<String , Integer> count(File file) throws InterruptedException, IOException {
        List<String> lines = Files.readAllLines(file.toPath());

        Map<String,Integer> wordToCountMap = new HashMap<>();

        for (String line:lines){
            String[] value = line.split("\\s+");

            for (String word: value) {
                Integer count = wordToCountMap.getOrDefault(word, 0);
                wordToCountMap.put(word,count+1);
            }

        }
        Thread.sleep(1000);
        return wordToCountMap;
    }
}