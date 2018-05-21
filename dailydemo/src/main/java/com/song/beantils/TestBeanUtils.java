package com.song.beantils;

import org.apache.commons.beanutils.BeanUtils;


public class TestBeanUtils {
    public static void main(String[] args) throws Exception {
        //从小到大可以转，从大到小不可转，不抛异常。名称优先
        big2small();
        small2big();

    }

    public static void big2small() throws Exception {
        MyUser myUser = new MyUser();
        myUser.setName("1");
        myUser.setPassword("2");
        //int ->long
        myUser.setIid(123);
        //long->int
        myUser.setLid(Long.MAX_VALUE);
        User user = new User();
        BeanUtils.copyProperties(user, myUser);
        System.out.println(user);
        System.out.println("-------------------------------");
    }

    public static void small2big() throws Exception {
        User user = new User();
        user.setName("1");
        user.setPassword("2");
        //long->int
        user.setIid(Long.MAX_VALUE);
        //int ->long
        user.setLid(123);
        MyUser myUser = new MyUser();
        BeanUtils.copyProperties(myUser, user);
        System.out.println(myUser);
        System.out.println("-------------------------------");
    }
}
