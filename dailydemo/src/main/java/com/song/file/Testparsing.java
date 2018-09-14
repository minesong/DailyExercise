package com.song.file;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Testparsing {


    public static final boolean isChineseCharacter(String chineseStr) {
        if (null == chineseStr) {
            return false;
        }
        char[] charArray = chineseStr.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if ((charArray[i] >= 0x4e00) && (charArray[i] <= 0x9fbb)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("abc".indexOf("a"));
        System.out.println("abc".indexOf("c"));
        System.out.println("abc".indexOf("d"));
        System.out.println(isChineseCharacter("123"));
        System.out.println(isChineseCharacter("12，3"));
        System.out.println(isChineseCharacter("a"));
        System.out.println(isChineseCharacter("1发23"));
        System.out.println(isChineseCharacter(" https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=25017023_10_pg&wd=java%20%E5%88%A4%E6%96%AD%E5%AD%97%E7%AC%A6%E4%B8%B2%E6%98%AF%E5%90%A6%E4%B8%AD%E6%96%87&oq=%25E5%2588%25A4%25E6%2596%25AD%25E5%25AD%2597%25E7%25AC%25A6%25E4%25B8%25B2%25E6%2598%25AF%25E5%2590%25A6%25E4%25B8%25AD%25E6%2596%2587&rsv_pq=dfa076d0000114ca&rsv_t=c52dHmgnWyFxeFduSI3QcITeQsmM4LHmk4ajOmb9yyOsui1OMkvYcQHjufKl2eZ8aDus95Q&rqlang=cn&rsv_enter=1&inputT=1208&rsv_sug3=13&rsv_sug1=5&rsv_sug7=100&rsv_sug2=0&rsv_sug4=2033"));
        String idNum = "if_dbus";
        String txtPath = "D:\\1.txt";
        new Parsing() {
            @Override
            public String spiltAndReplace(String line) {
                String[] targetLineArr = line.split("=");
                if (targetLineArr.length >= 2 && targetLineArr[1] != null) {
                    String target = targetLineArr[1].replaceAll(",", "").replaceAll("len", "").trim();
                    return target;
                }
                return null;
            }
        }.replaceStr(txtPath, idNum, "123");
    }
}
