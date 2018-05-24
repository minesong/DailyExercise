package com.song.testng.test;

import org.joda.time.DateTime;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateRelated {
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
