package com.alibaba.dubbo.demo.impl;
import org.springframework.stereotype.Component;
@Component
public class TargetClass implements TargetClassI {
    /**
     * 拼接两个字符串
     */
    public String joint(String str1, String str2) {
        return str1 + "+" + str2;
    }

}
