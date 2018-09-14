package com.song;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatterTest {
    public static void main(String[] args) {
        test(1000);
        test(100000);

        test(10000000);
        test(1000000);
    }
    public static void test(int times) {


        for (int k = 1; k <= 5; k++) {
            long t1 = System.currentTimeMillis();
            for (int i = 1; i < times; i++) {
                new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(new Date());
            }
            long t2 = System.currentTimeMillis();
            System.out.print(t2 - t1);
            System.out.println("    ---SimpleDateFormat 第" + k + "次，循环次数" + times + "------------------------------");
            t1 = System.currentTimeMillis();
            for (int i = 1; i < times; i++) {
                new DateTime(new Date()).toString("yy-MM-dd HH:mm:ss");
            }
            t2 = System.currentTimeMillis();
            System.out.print(t2 - t1);
            System.out.println("    ---dateTime 第" + k + "次，循环次数" + times + "------------------------------");
            System.out.println();
        }
        System.out.println("done");
        System.out.println();
    }
}
