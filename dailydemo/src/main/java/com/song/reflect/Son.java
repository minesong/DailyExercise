package com.song.reflect;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Son extends Parent {
    private Integer sid;
    protected String sname;
    public String spassword;
    String semail;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public static void main(String[] args) {
        Son son = new Son();
        getDeclaredFields(son);
        System.out.println("--------------");
        getFields(son);
        System.out.println("--------------");
        getSuperclassFields(son);

        System.out.println("--------------");
        getSuperclassgetDeclaredFields(son);

    }
    //获取当前类的所有属性，不包括弗雷
    public static void getDeclaredFields(Son son) {
        Class clazz = son.getClass();
        List<Field> fieldList = new ArrayList<>();

        fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));

        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        System.out.println(fieldList);
    }
    //只能获取当前类及父类的公共属性
    public static void getFields(Son son) {
        Class clazz = son.getClass();
        List<Field> fieldList = new ArrayList<>();

        fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getFields())));

        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        System.out.println(fieldList);
    }

    public static void getSuperclassFields(Son son) {
        Class clazz = son.getClass();
        List<Field> fieldList = new ArrayList<>();

        fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getSuperclass().getFields())));

        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        System.out.println(fieldList);
    }

    public static void getSuperclassgetDeclaredFields(Son son) {
        Class clazz = son.getClass();
        List<Field> fieldList = new ArrayList<>();

        fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields())));

        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        System.out.println(fieldList);
    }
}
