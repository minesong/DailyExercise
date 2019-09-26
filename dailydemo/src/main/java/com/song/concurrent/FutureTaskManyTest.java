package com.song.concurrent;


import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by scx on 2019/7/4.
 */
public class FutureTaskManyTest {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("hello", "java", "lamada");
        List<String[]> collect = list.stream().map(s -> s.split("")).collect(Collectors.toList());
        List<String> collect1 = collect.stream().flatMap(Arrays::stream).collect(Collectors.toList());
    }

}
