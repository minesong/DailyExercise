package com.song.beantils;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/*
https://blog.csdn.net/hjnth/article/details/79150198
*/
public class InitSequenceBean implements InitializingBean {
   /*
   InitSequenceBean constructor
    InitSequenceBean set age
    InitSequenceBean set properties
    InitSequenceBean postConstruct
    InitSequenceBean afterPropertiesSet
    InitSequenceBean initMethod
    */
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("dailydemo.xml");
    }

    private boolean properties;

    private Integer age;

    public InitSequenceBean() {
        System.out.println("InitSequenceBean constructor");
    }

    public void setProperties(boolean properties) {
        System.out.println("InitSequenceBean set properties");
        this.properties = properties;
    }

    public void setAge(Integer age) {
        System.out.println("InitSequenceBean set age");
        this.age = age;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitSequenceBean afterPropertiesSet");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("InitSequenceBean postConstruct");
    }

    public void initMethod() {
        System.out.println("InitSequenceBean initMethod");
    }

    public boolean isProperties() {
        return properties;
    }
}