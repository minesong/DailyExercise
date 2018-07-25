package com.song.ioutils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @Title: IOUtils
 * @Description: TODO
 * @date 2018/7/16
 */
public class IOUtilsTest {
    public static void main(String[] args) {

        String meString = "http://www.baidu.com";
        try {
            //模拟了http 请求
            String mes = IOUtils.toString(new URL(meString), "utf-8");
            System.out.println(mes);

        } catch (IOException e) {
            e.printStackTrace();
        }

        meString = "哈哈哈哈，下班了，hello";
        try {

            InputStream inputStream = IOUtils.toInputStream(meString, "utf-8");
            String mes = IOUtils.toString(inputStream, "utf-8");
            System.out.println(mes);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
