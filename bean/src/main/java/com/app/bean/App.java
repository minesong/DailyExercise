package com.app.bean;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.io.IOException;
import java.util.*;

public class App {
    public static void main(String[] args) throws IOException {
        Map<String,Integer> map = new HashMap<>();
        System.out.println(map.get("2q321"));
        System.out.println(StringUtils.isNumeric("123"));
        System.out.println(StringUtils.isNumeric("2c23"));
        System.out.println(StringUtils.isNumeric("  23"));
        System.out.println(StringUtils.isNumeric("2 3"));
        System.out.println(StringUtils.isNumeric(null));
        System.out.println(StringUtils.isNumeric(" "));
        System.out.println(Long.valueOf(null));
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(context.getDisplayName() + ": here");
        context.start();
    }
}
