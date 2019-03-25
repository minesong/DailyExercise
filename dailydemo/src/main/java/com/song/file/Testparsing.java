package com.song.file;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Objects;
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
        Long a = 1L;
        boolean f = 1L == 1;
        new Parsing().replaceStr("c://linker.ld", ">sys_mem", ">ram");
    }
}
