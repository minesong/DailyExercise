package com.song.simple;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;

public class LatticeTest {
    public static void main1(String[] args) throws Exception {
        Serializer serializer = new Persister();
        SystemEnv resultModel = null;
        File f = new File("D:\\sys_env.xml");
        resultModel = serializer.read(SystemEnv.class, f);
        System.out.println(resultModel);
    }
    public static void main(String[] args) throws Exception {
        Serializer serializer = new Persister();
        LatticeSystemEnv resultModel = null;
        File f = new File("D:\\sys_env(1).xml");
        resultModel = serializer.read(LatticeSystemEnv.class, f);
        System.out.println(resultModel);
    }
}

