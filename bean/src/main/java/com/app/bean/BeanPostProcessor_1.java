package com.app.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessor_1 implements BeanPostProcessor {
    /**
     * 在bean实例化前调用
     */
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("beanName-1-----------" + s);
        return o;
    }

    /**
     * 在bean实例化后调用，如果bean实现了InitializingBean，则在执行完
     * 该接口的afterPropertiesSet方法后调用 ，如果实现了init-method则
     * 在执行完init-method后调用
     */
    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return o;
    }
}
