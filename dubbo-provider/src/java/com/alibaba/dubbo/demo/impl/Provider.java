package com.alibaba.dubbo.demo.impl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by wy on 2017/4/13.
 */
public class Provider {
        public static void main(String[] args) throws IOException {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
            System.out.println(context.getDisplayName() + ": here");
            context.start();
            System.out.println("服务已经启动...");
            //System.in.read()返回的是输入数值的 ASKII 码（一个 int 整数）
           // System.in.read();
            while (true);
        }
    }

