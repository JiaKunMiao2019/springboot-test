/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AsyncTaskService
 * Author:   莉莉
 * Date:     2020/7/29 11:52
 * Description: 任务执行类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cctv.Async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈任务执行类〉
 *
 * @author 莉莉
 * @create 2020/7/29
 * @since 1.0.0
 */
@Service
public class AsyncTaskService {
    @Async
    public void executeAsyncTask(Integer i){
        System.out.println("执行异步任务：" + i);
    }

    @Async
    public void executeAsyncTaskTwo(Integer i){
        System.out.println("执行异步任务：" + i);
    }

}