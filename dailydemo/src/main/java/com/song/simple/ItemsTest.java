package com.song.simple;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ItemsTest {
    public static void main(String[] args) throws Exception {
        Map<String, BigDecimal> map = new HashMap<>();
        map.put("1", BigDecimal.ONE);
        map.get("1").add(BigDecimal.TEN);
        System.out.println(map);

        long t1 = System.currentTimeMillis();
        for (int k = 1; k <= 1000; k++)
            for (int i = 100; i < 1000; i++) {
                if (isNarcissisticNumber2(i)) {
                    System.out.println(i);
                }
            }
        long t2 = System.currentTimeMillis();
        for (int k = 1; k <= 1000; k++)
            for (int i = 100; i < 1000; i++) {
                if (isNarcissisticNumber(i)) {
                    System.out.println(i);
                }
            }
        long t3 = System.currentTimeMillis();
        System.out.println("------");
        System.out.println(t2 - t1);
        System.out.println(t3 - t2);
        Serializer serializer = new Persister();
        Items resultModel = null;
        File f = new File("D:\\song.xml");
        resultModel = serializer.read(Items.class, f);
        resultModel.getRows();
        resultModel.getTotalResults();
        resultModel.getTotalResultsAll();
        System.out.println(resultModel);
    }

    public static boolean isNarcissisticNumber(Integer num) {
        if (null == num || num < 100 || num > 1000) {
            return false;
        }
        int ge = num % 10;
        int shi = num / 10 % 10;
        int bai = num / 100;
        if (num - ge * ge * ge - shi * shi * shi == bai * bai * bai) {
            return true;
        }
        return false;
    }

    public static boolean isNarcissisticNumber2(Integer num) {
        if (null == num || num < 100 || num > 1000) {
            return false;
        }
        String str = num.toString();
        int ge = str.charAt(2) - '0';
        int shi = str.charAt(1) - '0';
        int bai = str.charAt(0) - '0';
        if (num - ge * ge * ge - shi * shi * shi == bai * bai * bai) {
            return true;
        }
        return false;
    }
}
