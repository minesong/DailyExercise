package com.song.testng.test;

import org.apache.commons.collections.MultiMap;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestNG {
    class  A {
        public Integer a;

        public Integer getA() {
            return a;
        }

        public void setA(Integer a) {
            this.a = a;
        }
    }
    @Test
    public void testMap() {
        List<A> aList = new ArrayList<>();
        for (A a:aList) {
            System.out.println(1);
        }
        A aa = new A();
        aa.setA(1);
        aList.add(aa);
        //aa = new A();
        aa.setA(2);
        aList.add(aa);
        boolean a = true;
        boolean b = false;
        Map<Integer, Boolean> map = new HashMap<>();
        map.put(1, a || b);
        map.put(2, b || a);
        map.put(3, a && b);
        map.put(4, a & b);
        map.put(5, a == false || b == true);
        map.put(6, b == true || a == true);
        System.out.println(map);
    }

    @Test
    public void testcase1() {
        Assert.assertTrue(true);
        System.out.println("testcase1");
    }

    @Test
    public void testListRemove() {
        try {

            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<String> stringList = Lists.newArrayList();
        stringList.add("123");
        stringList.add("6");
        Objects.equals(1, 2);
        //stringList.remove("123");
        System.out.println(stringList);
        //stringList.remove("123");
        System.out.println(stringList);
        //stringList.remove("888");
        //System.out.println(stringList);
        //stringList.remove("6");
        System.out.println(stringList);
        //stringList.remove("6");
        System.out.println(stringList);
        String s = ToStringBuilder.reflectionToString(stringList);
    }

    @Test
    public void test_disjoint() {
        List<Integer> id1 = new ArrayList<>();
        id1.add(1);
        id1.add(2);
        id1.add(3);
        Set<Integer> id2 = new HashSet<>();
        id2.add(4);
        id2.add(5);
        id2.add(6);
        System.out.println(Collections.disjoint(id1, id2));
    }

    @Test
    public void test_getFilePath() throws IOException {
        System.out.println("------默认相对路径，取得路径不同-----");
        File f1 = new File("..\\src\\file");
        System.out.println(f1.getPath());
        System.out.println(f1.getAbsolutePath());
        System.out.println(f1.getCanonicalPath());
        System.out.println("------默认相对路径，取得路径不同-----");
        File f2 = new File(".\\src\\file");
        System.out.println(f2.getPath());
        System.out.println(f2.getAbsolutePath());
        System.out.println(f2.getCanonicalPath());
        System.out.println("------默认绝对路径，取得路径相同-----");
        File f3 = new File("C:\\src\\file");
        System.out.println(f3.getPath());
        System.out.println(f3.getAbsolutePath());
        System.out.println(f3.getCanonicalPath());
    }

}
