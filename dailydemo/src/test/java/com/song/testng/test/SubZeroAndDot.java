package com.song.testng.test;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.text.DecimalFormat;

public class SubZeroAndDot {
    @Test
    public void testInteeger() {
        Object on = 0.01;
        DecimalFormat decimalFormat = new DecimalFormat("0");
        Integer num = Integer.parseInt(decimalFormat.format(on));
        System.out.println(num);
    }
    /**
     * 去掉数字小数点及后面的0
     *
     * @param s
     * @return
     */
    public static String subZeroAndDot(String s) {
        if (StringUtils.isBlank(s)) {
            return null;
        }
        if (s.indexOf(".") > 0) {
            s = s.replaceAll("0+?$", "");
            s = s.replaceAll("[.]$", "");
        }
        return s;
    }

    @Test
    public void testsubZeroAndDot() {
        Float f = 1.0F;
        System.out.println(f.toString());
        System.out.println(subZeroAndDot("1"));
        System.out.println(subZeroAndDot("10"));
        System.out.println(subZeroAndDot("1.0"));
        System.out.println(subZeroAndDot("1.010"));
        System.out.println(subZeroAndDot("10.01"));
        System.out.println(subZeroAndDot("10.00"));
    }
}
