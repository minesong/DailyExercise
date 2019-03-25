package com.song.file;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by songchengxiang on 2019/1/14.
 */
public class Person implements Serializable {
    public static void main(String[] args) {
       String string =  "2020894,\n" +
                "2020896,\n" +
                "2133576,\n" +
                "2133576,\n" +
                "2133585,\n" +
                "2049865,\n" +
                "1790379,\n" +
                "1795025,\n" +
                "2508810,\n" +
                "2570727,\n" +
                "2766924,";
       String[]strings =string.split(",");
        System.out.println(string);
    }

    /**
     * 姓名
     */
    private String name;

    private Integer age;
    /**
     * 兄弟姐妹
     */
    private Person siblings;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getSiblings() {
        return siblings;
    }

    public void setSiblings(Person siblings) {
        this.siblings = siblings;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public static int compareStrFront3Char(String first, String second) {
        if (first == null && second == null) {
            return 0;
        }
        if (first == null && second != null) {
            return -1;
        }
        if (first != null && second == null) {
            return 1;
        }
        first = first.length() > 3 ? first.substring(0, 3) : first;
        second = second.length() > 3 ? second.substring(0, 3) : second;
        return first.compareTo(second);
    }
}

class Per implements Serializable {
    /**
     * 姓名
     */
    private Integer name;
    /**
     * 兄弟姐妹
     */
    private Person siblings;

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public Person getSiblings() {
        return siblings;
    }

    public void setSiblings(Person siblings) {
        this.siblings = siblings;
    }
}
