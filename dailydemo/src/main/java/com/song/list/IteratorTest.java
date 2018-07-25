package com.song.list;


import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

import java.util.Iterator;
import java.util.List;

public class IteratorTest {
    public static void main(String[] args) {
        Multimap<String, Object> map = ArrayListMultimap.create();
        map.put("1", 2);
        map.put("1", 2);
        map.put("1", 3);
        System.out.println(map.get("1"));
        List<Integer> list = Lists.newArrayList();
        list.add(1);
        list.add(5);
        list.add(5);
        list.add(6);
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(3);
        list.add(6);

        Iterator<Integer> integerIterator = list.iterator();
        while (integerIterator.hasNext()) {

            Integer i = integerIterator.next();
            System.out.println(i);
            if (i == 6 || i == 5) {
                integerIterator.remove();
            }
        }

        System.out.println(list);
    }
}
