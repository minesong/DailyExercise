package com.song.testng.test;

import com.song.Person;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by scx on 2019/6/20.
 */
public class MapTest {
    @Test
    public void testNull() {
        Map<Integer, Person> map = new HashMap<>();
        map.put(1,new Person());
        map.compute(1, (k, v) -> {
            if (v == null) {
                v = new Person();
                return v;
            }
            v.setAge(123);
            return v;
        });
        System.out.println(map);
    }

    @Test
    public void testPutIfAbsent() {
        String ret;
        //注意：如果使用put方法存储，当key重复时，put方法返回原来的value值。
        //putIfAbsent亦是如此
        Map<String, String> map = new HashMap<>();
        ret = map.putIfAbsent("a", "aaa"); //ret 为"null", map 为 {"a":"aaa"}
        ret = map.putIfAbsent("a", "bbb"); //ret 为 "aaa", map 还是 {"a":"aaa"}
        map.put("b", null);
        ret = map.putIfAbsent("b", "bbb"); //ret 为 null, map 为 {"a":"aaa","b":"bbb"}
    }

    @Test
    public void testCompute() {
        String ret;
        //若newValue 为null，不进行put操作并且删除老的key和value（若存在），否则就进行put操作
        //返回值为当前的newValue 值
        Map<String, String> map = new HashMap<>();
        ret = map.compute("a", (key, value) -> "a" + value); //ret="anull", map={"a":"anull"}
        ret = map.compute("a", (key, value) -> "a" + value); //ret="aanull", map={"a":"aanull"}
        ret = map.compute("a", (key, value) -> null); //ret=null, map={}
    }

    //计算出的值为 null 时直接删除 key 而不是设置对应 key 的值为 null,
    // 这能照顾到值不能为 null 的 Map 实现，如 Hashtable 和 ConcurrentMap。
    @Test
    public void testComputeIfPresent() {
        String ret;
        Map<String, String> map = new HashMap<>();
        //只对已经存在key的进行操作,且oldVlaue 不为null
        //返回值为如果当前的 map.get(key)
        ret = map.computeIfPresent("a", (key, value) -> key + value); //ret null, map 为 {}
        map.put("a", null); //map 为 ["a":null]
        ret = map.computeIfPresent("a", (key, value) -> key + value); //ret null, map 为 {"a":null}
        map.put("a", "+aaa");
        ret = map.computeIfPresent("a", (key, value) -> key + value); //ret "a+aaa", map 为 {"a":"a+aaa"}
        ret = map.computeIfPresent("a", (key, value) -> null); //ret 为 null, map 为 {}，计算出的 null 把 key 删除了
    }

    @Test
    public void testComputeIfAbsent() {
        String ret;
        Map<String, String> map = new HashMap<>();
        ret = map.computeIfAbsent("a", key -> key + "123"); //ret "a123", map 为 {"a":"a123"}
        ret = map.computeIfAbsent("a", key -> key + "456"); //ret "a123", map 为 {"a":"a123"}
        map.put("a", null);
        ret = map.computeIfAbsent("a", key -> key + "456"); //ret "a456", map 为 {"a":"a456"}
        ret = map.computeIfAbsent("a", key -> null); //ret 为 "a456", map 为 {"a":"a456"}
    }

    @Test
    public void testReplace() {
        String ret;
        //有则替换，无则退出
        Map<String, String> map = new Hashtable<>();
        ret = map.replace("a", "abc"); //ret 为 null，map 为 {}
        map.put("a", "ddd");
        ret = map.replace("a", "abc"); //ret 为 "ddd", map 为 {"a":"abc"}
        ret = map.replace("a", null); //ret 为 "abc", map 为 {"a":null}
        ret = map.replace("a", "ddd"); //ret 为 null, map 为 {"a":"ddd"}
    }

    @Test
    public void testReplace2() {
        boolean ret;
        Map<String, String> map = new HashMap<>();
        //返回值为boolean
        ret = map.replace("a", null, "aaa"); //ret 为 false, map 为 {}
        map.put("a", null);
        ret = map.replace("a", null, "aaa"); //ret 为 true, map 为 {"a":"aaa"}
        ret = map.replace("a", "aaa", null); //ret 为 true, map 为 {"a":null}
        ret = map.replace("a", "aaa", "bbb");//ret 为 false, map 为 {"a":null}
    }

    @Test
    public void testReplaceAll() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "aaa");
        map.put("b", "bbb"); //map 为 {"a":"aaa","b":"bbb"}
        map.replaceAll((key, value) -> key + "-" + value); //map 为 {"a":"a-aaa","b":"b-bbb"}
    }

    @Test
    public void testRemove() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "aaa");
        map.put("b", "bbb"); //map 为 {"a":"aaa","b":"bbb"}
        map.remove("a", "b"); //map 为 {"a":"a-aaa","b":"b-bbb"}
    }

    @Test
    public void testMerge() {
        //注意 value 不能为 null 值
        String ret;
        Map<String, String> map = new HashMap<>();
        ret = map.merge("a", "aa", (oldValue, value) -> oldValue + "-" + value);
        //ret="aa", map={"a":"aa"}
        ret = map.merge("a", "bb", (oldValue, value) -> oldValue + "-" + value);
        //ret="aa-bb", map={"a":"aa-bb"}
        ret = map.merge("a", "bb", (oldValue, value) -> null);
        //ret=null, map={}
        map.put("a", null);
        ret = map.merge("a", "aa", (oldValue, value) -> oldValue + "-" + value);
        //ret="aa", map={"a":"aa"}
        map.put("a", null);
        ret = map.merge("a", "bb", (oldValue, value) -> null);
        //ret="bb", map={"a":"bb"}
        ret = map.merge("a", null, (oldValue, value) -> oldValue + "-" + value);              //NullPointerException, value 不能为 null
    }

    @Test
    public void testCompare() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "b");
        map.put("1", "3");
        map.put("c", "d");
        map.put("b", "2");
        map.put("f", "1");
        List<Map.Entry<String, String>> list = null;
        list = map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList());
        list = map.entrySet().stream().sorted(Map.Entry.comparingByKey(String::compareTo)).collect(Collectors.toList());
        list = map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toList());
        list = map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue(String::compareTo))).collect(Collectors.toList());

    }

    public static void main(String[] args) {
        //计算偶数和奇数的个数
        List<Integer> integerList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            integerList.add(random.nextInt(1000));
        }
        Map<String, Integer> result = new HashMap<>();
        for (Integer integer : integerList) {
            String tag = "Even";
            if (integer % 2 == 0) {
                tag = "Odd";
            }
            //一个累加操作
            result.merge(tag, 1, (a, b) -> a + b);
        }
        result.forEach((k, v) -> {
            System.out.println(k + " <-> " + v);
        });
        String key = Collections.max(result.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println(key);
    }
}