package com.app.bean;

import org.springframework.beans.factory.InitializingBean;

public class TestBean2 implements InitializingBean {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void init() {
        System.out.println("init-method-2 is called");
        System.out.println("******************************");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("******************************");
        System.out.println("afterPropertiesSet-2 is called");
        System.out.println("******************************");
    }
}
