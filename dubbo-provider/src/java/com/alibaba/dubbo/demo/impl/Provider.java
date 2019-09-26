package com.alibaba.dubbo.demo.impl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by wy on 2017/4/13.
 */
public class Provider {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("provider.xml");
        System.out.println(ctx.getDisplayName() + ": here");
        ctx.start();
        //2、从IOC容器中获取bean的实例
        TargetClassI targetClass = (TargetClassI) ctx.getBean("targetClass");
        Object p = ctx.getBean("aopAspect");

        //3、使用bean
        String result = targetClass.joint("spring", "aop");
        System.out.println("result:" + result);
    }
}

