/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ScheduledTaskService
 * Author:   莉莉
 * Date:     2020/7/29 14:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cctv.TaskScheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 莉莉
 * @create 2020/7/29
 * @since 1.0.0
 */
@Service
public class ScheduledTaskService {
    private static final SimpleDateFormat DATE_FORMAT
            = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        System.out.println("每隔5秒执行一次："+DATE_FORMAT.format(new Date()));
    }

    @Scheduled(cron = "0 26 14 ? * *")
    public void fixTimeExecution(){
        System.out.println("在指定时间："+ DATE_FORMAT.format(new Date()) +"执行");
    }

}