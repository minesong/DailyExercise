package com.song.ioutils;

import java.lang.reflect.*;

public class Son extends Person {
    private Long age1;
    public String name1;
    protected Long num1;
    Long level1;

    public static void main(String[] args) {
        Son son =new Son();
        Field[] field = son.getClass().getDeclaredFields();
        Field[] field1 = son.getClass().getFields();
        Field[] field3 = son.getClass().getSuperclass().getDeclaredFields();

        Field[] field4 = son.getClass().getSuperclass().getFields();
        System.out.println();
    }
}
