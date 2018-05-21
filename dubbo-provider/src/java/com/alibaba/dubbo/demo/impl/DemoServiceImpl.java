package com.alibaba.dubbo.demo.impl;

import com.alibaba.dubbo.demo.DemoService;
import com.alibaba.dubbo.demo.MyUser;

import java.util.ArrayList;
import java.util.List;

public class DemoServiceImpl implements DemoService {
    public List<String> getPermissions(Long id) {
        List<String> demo = new ArrayList<String>();
        demo.add(String.format("Permission_%d", id - 1));
        demo.add(String.format("Permission_%d", id));
        demo.add(String.format("Permission_%d", id + 1));
        return demo;
    }

    @Override
    public void testObjectIsChanged(MyUser myUser) {
        myUser.setName("testObjectIsChanged");
        System.out.println(myUser);
    }

    @Override
    public void testObjectIsChanged1(MyUser myUser) {
        myUser.setName("testObjectIsChanged");
        System.out.println(123456);
    }
}
