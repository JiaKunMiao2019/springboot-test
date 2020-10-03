/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ThreadFockJioin
 * Author:   莉莉
 * Date:     2020/9/6 22:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cctv.ThreadUser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import static com.cctv.ThreadUser.ThreadCoorditionStream.count;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 莉莉
 * @create 2020/9/6
 * @since 1.0.0
 */
public class ThreadFockJioin {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<File> files = Arrays.asList(
                new File("1"),
                new File("2"),
                new File("3"));
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println(pool.submit(new WorkCount(files)).get());
    }

    static class WorkCount extends RecursiveTask<Map<String,Integer>>{
        List<File> files;

        public WorkCount(List<File> files){
            this.files = files;
        }
        @Override
        protected Map<String, Integer> compute() {
            if (files.isEmpty()){
              return  Collections.emptyMap();
            }
            try {
                Map<String,Integer> workCount = count(files.get(0));
                Map<String,Integer> countOfRestFiles =
                        new WorkCount(files.subList(1,files.size())).compute();
                return merge(workCount,countOfRestFiles);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        private Map<String, Integer> merge(Map<String, Integer> map1, Map<String, Integer> map2) {
            HashSet<String> words = new HashSet<>(map1.keySet());
            words.addAll(map2.keySet());

            HashMap<String, Integer> map = new HashMap<>();
            for (String word:words) {
                map.put(word,map1.getOrDefault(word,0)+map2.getOrDefault(word,0));
            }
            return map;
        }
    }
}