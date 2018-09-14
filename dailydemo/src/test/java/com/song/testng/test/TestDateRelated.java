package com.song.testng.test;

import org.joda.time.DateTime;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class TestDateRelated {
    @Test
    public void test正则表达式() {

        Pattern pattern = Pattern.compile("^\\d+$");
        System.out.println("a123".matches("[0-9]+?$"));

        System.out.println("12a3".matches("^[0-9]+?$"));
        System.out.println("a123".matches("^[0-9]+?$"));
        System.out.println("123a".matches("^[0-9]+?$"));
        System.out.println("".matches("^[0-9]+?$"));
        System.out.println(pattern.matcher("123").matches());
        System.out.println(pattern.matcher("123a").matches());
        System.out.println(pattern.matcher("a123").matches());
        System.out.println(pattern.matcher("12a3").matches());
        System.out.println(pattern.matcher("a").matches());
        System.out.println(pattern.matcher(" ").matches());
    }

    @Test
    public void testAfterBefore() {
        Date date1 = new Date();
        Date date2 = new Date();
        System.out.println(date1.after(date2));
        System.out.println(date1.before(date2));
        System.out.println(date1.equals(date2));
    }

    @Test
    public void testDate2String() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:hh-mm-ss");
        java.util.Date date = new java.util.Date();
        String str = sdf.format(date);
        Assert.assertNotNull(str);
    }

    @Test
    public void testString2Date() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:hh-mm-ss");
        Date date = sdf.parse("2017-12-8:1-1-1");
        Assert.assertNotNull(date);
    }

    @Test
    public void testJoda() {
        DateTime now = new DateTime();
        String nowString = now.toString();
        String nowString2 = now.toString("yyyy-MM-dd HH:mm:ss");
        Date date = now.toDate();
        Assert.assertNotNull(date);
        now = new DateTime(date.getTime());
    }
}
