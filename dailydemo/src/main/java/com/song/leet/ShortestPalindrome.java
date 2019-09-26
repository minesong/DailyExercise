package com.song.leet;

public class ShortestPalindrome {

    public String shortestPalindrome(String s) {
        if (isValid(s)) {
            return s;
        }
        StringBuilder plus = new StringBuilder();
        for (int i = s.length() - 1; i >= 1; i--) {
            plus.append(s.charAt(i));
            if (isValid(plus.toString() + s)) {
                break;
            }
        }
        return plus.append(s).toString();
    }

    private boolean isValid(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

}
