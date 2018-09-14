package com.song.beantils;

import com.song.Person;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.joda.time.DateTime;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.Date;

public class BeanUtilsAPP {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        DateTime time = new DateTime(new Timestamp(System.currentTimeMillis()));
        test(1000000);
        test(1000);
        test(100000);


        test(10000000);
    }

    private static void test(int times) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Person person = new Person(1, "s");
        Person tar = new Person();
        for (int k = 1; k <= 5; k++) {
            long t1 = System.currentTimeMillis();
            for (int i = 1; i < times; i++) {
                BeanUtils.copyProperties(tar, person);
            }
            long t2 = System.currentTimeMillis();
            System.out.print(t2 - t1);
            System.out.println("    ---apache 第" + k + "次，循环次数" + times + "------------------------------");
            t1 = System.currentTimeMillis();
            for (int i = 1; i < times; i++) {
                org.springframework.beans.BeanUtils.copyProperties(person, tar);
            }
            t2 = System.currentTimeMillis();
            System.out.print(t2 - t1);
            System.out.println("    ---spring 第" + k + "次，循环次数" + times + "------------------------------");
            t1 = System.currentTimeMillis();

            for (int i = 1; i < times; i++) {
                PropertyUtils.copyProperties(tar, person);
            }
            t2 = System.currentTimeMillis();
            System.out.print(t2 - t1);
            System.out.println("    ---property 第" + k + "次，循环次数" + times + "------------------------------");
            System.out.println();
        }
        System.out.println("done");
        System.out.println();
    }
}
