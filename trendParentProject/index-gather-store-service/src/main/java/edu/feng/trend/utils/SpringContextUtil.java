package edu.feng.trend.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @program: trendParentProject
 * @description: TODO
 * @author: feng
 * @create: 2020-05-10 22:17
 * @version: 1.0
 */

@Component
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("SpringContext: " + applicationContext);
        SpringContextUtil.applicationContext = applicationContext;
    }

    private SpringContextUtil() {
        System.out.println("SpringContextUtil");
    }

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }
}