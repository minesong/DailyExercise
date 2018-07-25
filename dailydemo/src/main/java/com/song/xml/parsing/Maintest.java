package com.song.xml.parsing;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;

public class Maintest {
    public Maintest() throws Exception {
    	
        Serializer serializer = new Persister();
        SystemEnv resultModel = null;
        File f = new File("D:\\sys_env.xml");
        resultModel = serializer.read(SystemEnv.class, f);
        String name =  resultModel.getLatticeSystem().get(1).getComponent().get(0).getMemoryMaps().get(0).getMemoryMap().get(0).getAddressBlock().get(0).getSpiritName();
        System.out.println(name);
    }

}
