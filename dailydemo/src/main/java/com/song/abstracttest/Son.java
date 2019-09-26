package com.song.abstracttest;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author songchengxiang<songchengxiang @ corp.netease.com>
 * @Title: Son
 * @Description: TODO
 * @date 2018/7/18
 */
public class Son extends Parents {
    public static void main(String[] args) throws InterruptedException {
        String a = null;
        String b = "1";
        String c = Optional.ofNullable(a).filter(StringUtils::isNotBlank).orElse("12");
        String d = Optional.ofNullable(b).filter(StringUtils::isNotBlank).orElse("123");

        ReentrantLock lock = new ReentrantLock(false);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(11);
                lock.lock();
                System.out.println(12);
                lock.unlock();
                System.out.println(13);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(31);
                lock.lock();
                System.out.println(32);
                lock.unlock();
                System.out.println(33);

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(21);
                lock.lock();
                System.out.println(22);
                lock.unlock();
                System.out.println(23);

            }
        }).start();
    }

    @Override
    public void getBirth() {
        System.out.println("Son:getBirth");
    }

    @Override
    public void getAge() {
        System.out.println("Son:getAge");
    }
}
