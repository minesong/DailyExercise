package com.alibaba.dubbo.consumer;

import com.alibaba.dubbo.demo.DemoService;
import com.alibaba.dubbo.demo.MyUser;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;

public class Consumer {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        MyUser myUser = new MyUser();
        myUser.setName("1");
        myUser.setPassword("2");
        //测试常规服务
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        System.out.println("consumer start");
        DemoService demoService = context.getBean(DemoService.class);
        System.out.println("consumer");
        //System.out.println(demoService.getPermissions(1L));

        try {
            demoService.testObjectIsChanged1(myUser);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(myUser.getName());
    }
}
