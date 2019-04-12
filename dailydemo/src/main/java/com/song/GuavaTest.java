package com.song;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import org.testng.collections.Lists;

import java.util.ArrayList;
import java.util.List;

public class GuavaTest {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("1", "2", null, "3");

        String res = Joiner.on(",").skipNulls().join(list);
        System.out.println(res);
        Person person = new Person();
        String text = JSON.toJSONString(person);
        Person person1 = JSON.parseObject(text, Person.class);
        System.out.println(person1);
    }
}
