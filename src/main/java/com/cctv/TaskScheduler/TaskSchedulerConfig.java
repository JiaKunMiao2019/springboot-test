/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TaskSchedulerConfig
 * Author:   莉莉
 * Date:     2020/7/29 14:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cctv.TaskScheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 莉莉
 * @create 2020/7/29
 * @since 1.0.0
 */
@Configuration
@ComponentScan("com.cctv.TaskScheduler")
@EnableScheduling
public class TaskSchedulerConfig {

}