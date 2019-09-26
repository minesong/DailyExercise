package com.song.testng.test;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class BigNumProcess {
    public static void main(String[] args) throws Exception {
        System.out.println(removeStaleZero("000000"));
        System.out.println(removeStaleZero("00010"));
        System.out.println(removeStaleZero("1020300"));
        System.out.println(add("1", "9999992131231231"));
        System.out.println(add("3", "2"));
        System.out.println(NumberUtils.isDigits("00000000"));
    }

    public static String add(String num1, String num2) throws Exception {
        if (!NumberUtils.isDigits(num1) || !NumberUtils.isDigits(num2)) {
            throw new IllegalArgumentException("非数字");
        }
        num1 = removeStaleZero(num1);
        num2 = removeStaleZero(num2);
        if (num1.equals("0")) {
            return num2;
        }
        if (num2.equals("0")) {
            return num1;
        }
        if (num2.length() > num1.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        int ml1 = num1.length();
        int ml2 = num2.length();
        int flag = 0;
        int[] res = new int[ml1 + 1];
        int i;
        for (i = 0; i < num1.length(); i++) {
            int c1 = num1.charAt(ml1 - 1 - i) - '0';
            int c2 = 0;
            if (i < num2.length()) {
                c2 = num2.charAt(ml2 - 1 - i) - '0';
            }

            int r = c1 + c2 + flag;
            if (r > 9) {
                flag = r / 10;
            }
            res[ml1 - i] = r % 10;
        }
        res[0] = flag;
        System.out.println(StringUtils.join(res, ','));
        String s = "";
        for (i = 0; i < res.length; i++) {
            s += res[i];
        }
        return removeStaleZero(s);

    }

    static String removeStaleZero(String num) {
        num = StringUtils.deleteWhitespace(num);
        if (StringUtils.isEmpty(num)) {
            return num;
        }
        int i = 0;
        for (; i < num.length() - 1 && num.charAt(i) == '0'; i++) ;
        return num.substring(i);
    }
}
