/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AwareService
 * Author:   莉莉
 * Date:     2020/7/28 21:55
 * Description: 定义Aware的类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cctv.SpringAware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈定义Aware的类〉
 *
 * @author 莉莉
 * @create 2020/7/28
 * @since 1.0.0
 */
public class AwareService implements BeanNameAware, ResourceLoaderAware {
    private String beanName;
    private ResourceLoader resourceLoader;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void outputResult(){
        System.out.println("Bean名称：" + beanName);
        Resource resource = resourceLoader.getResource("classpath:com/cctv/SpringEL/test.txt");
        try {
            System.out.println("ResourceLoader加载文件内容为："+ IOUtils.toString(resource.getInputStream()));
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}