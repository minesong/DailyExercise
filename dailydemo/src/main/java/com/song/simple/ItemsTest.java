package com.song.simple;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;

public class ItemsTest {
    public static void main(String[] args) throws Exception {
        Serializer serializer = new Persister();
        Items resultModel = null;
        File f = new File("D:\\song.xml");
        resultModel = serializer.read(Items.class, f);
        resultModel.getRows();
        resultModel.getTotalResults();
        resultModel.getTotalResultsAll();
        System.out.println(resultModel);
    }
}
