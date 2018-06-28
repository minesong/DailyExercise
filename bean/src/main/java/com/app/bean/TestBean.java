package com.app.bean;

import org.springframework.beans.factory.InitializingBean;

public class TestBean implements InitializingBean {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void init() {
        System.out.println("init-method is called");
        System.out.println("******************************");
    }

    /* InitializingBean 为实现该接口的bean提供默认的初始化方法
     * 也可以在xml配置bean的使用init-method来实现初始化方法
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("******************************");
        System.out.println("afterPropertiesSet is called");
        System.out.println("******************************");
    }
}
