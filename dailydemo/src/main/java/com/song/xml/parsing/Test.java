package com.song.xml.parsing;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;
import java.util.Objects;

/**
 * @author scx
 * @Title: Test
 * @Description: TODO
 * @date 2018/7/6
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Object s1 = "123";
        String s2 = new String("123");
        System.out.println(s1.equals(s2));
        String str = "1--2--3";
        String []strs = str.split("--");
        str ="--1--2";
        strs = str.split("--");
        str ="----";
        strs = str.split("--");
        str ="----1";
        strs = str.split("--");
        str ="--1--";
        strs = str.split("--");
        str ="1----";
        strs = str.split("--");
        Object aa = new Integer(1);
        System.out.println(aa.equals(null));
        System.out.println(null == null);
        BigDecimal b1 = new BigDecimal("0");
        BigDecimal b2 = new BigDecimal("0.00");
        System.out.println(b1.compareTo(b2));
        Object a = 129;
        Integer b =129;
        int bb =129;
        System.out.println(a==b);
        System.out.println(a==bb);
        System.out.println(b.equals(a));
        a =1;
        b =1;
        bb =1;
        System.out.println(Objects.equals(a,bb));
        System.out.println(a==b);
        System.out.println(a==bb);
        System.out.println(b.equals(a));
        Object c = 1.2;
        Float d = 1.2f;
        Double e = 1.2;
        System.out.println(d.equals(c));
        System.out.println(e.equals(c));
        System.out.println(e==c);
        BigDecimal bigDecimal = new BigDecimal("0");
        String ss = bigDecimal.toString();
        System.out.println(bigDecimal.toString());
        Serializer serializer = new Persister();


        SystemEnv resultModel = null;
        String realPath = SystemEnv.class.getClassLoader().getResource("")
                .getFile();
        java.io.File file = new java.io.File(realPath);
        realPath = file.getAbsolutePath();
        try {
            realPath = java.net.URLDecoder.decode(realPath, "utf-8");
        } catch (Exception ez) {
            ez.printStackTrace();
        }

        String s =  SystemEnv.class.getResource(ParamConfig.sysEnvPath).getPath();
        //String s = new File("sys_env.xml").getCanonicalPath();
        File f = new File(s);
        resultModel = serializer.read(SystemEnv.class, f);
        //System.out.println(resultModel);

        SpiritComponent spiritComponent = resultModel.getLatticeSystem().get(0).getComponent().get(2);

        System.out.println(spiritComponent.getSpiritVendor());
        System.out.println(spiritComponent.getSpiritLibrary());
        System.out.println(spiritComponent.getSpiritLibrary());
        System.out.println(spiritComponent.getSpiritName());
        System.out.println(spiritComponent.getSpiritVersion());
        List<AddressSpace> addressSpaces = spiritComponent.getAddressSpaces().get(0).getAddressSpace();
        if (null != addressSpaces && addressSpaces.size() > 0) {
            for (AddressSpace addressSpace : addressSpaces) {
                if (null != addressSpace.getSpiritName() && addressSpace.getSpiritName().equals("riscv_if_fetch_Address_Space")) {
                    System.out.println(addressSpace.getSpiritName());
                    System.out.println(addressSpace.getSpiritWidth());
                    System.out.println(addressSpace.getSpiritRange());
                    //如果有重名就不要break了
                    break;
                }
            }

        }
        String name = resultModel.getLatticeSystem().get(0).getComponent().get(0).getMemoryMaps().get(0).getMemoryMap().get(0).getAddressBlock().get(0).getSpiritName();
        System.out.println(name);
    }
}
