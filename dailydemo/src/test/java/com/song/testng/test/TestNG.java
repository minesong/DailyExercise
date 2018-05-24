package com.song.testng.test;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class TestNG {

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
        Objects.equals(1,2);
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
        String s =   ToStringBuilder.reflectionToString(stringList);
    }


}
