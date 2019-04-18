package com.song.list;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.song.Person;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class IteratorTest {
    public static void main(String[] args) throws ParseException {

        long t1 = System.currentTimeMillis();
        for (int i = 1; i <= 100000; i++) {
            IntegerCalUtils.add(new BigDecimal(String.valueOf(i)), null);
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
        for (int i = 1; i <= 100000; i++) {
            IntegerCalUtils.addNew(new BigDecimal(String.valueOf(i)), null);
        }
        long t3 = System.currentTimeMillis();
        System.out.println(t3 - t2);


        List<Person> personList = Lists.newArrayList(new Person(1, "s"), new Person(null, "c"), new Person(2, "x"), new Person(1, "z"));
        CollectionUtils.filter(personList, new Predicate() {
                    @Override
                    public boolean evaluate(Object o) {
                        Person p = (Person) o;
                        return p.getAge() != null;
                    }
                }
        );

        System.out.println(personList);
        List<Integer> list = Lists.newArrayList();
        List<BigDecimal> list1 = Lists.newArrayList();
        list1.add(null);
        BigDecimal he = list1.stream().filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add);
        list.remove(Integer.valueOf(1));
        list.add(1);
        list.add(null);
        list.add(5);
        //System.out.println(l);
        System.out.println(list);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date date = format.parse("19700101");
        System.out.println(date.getTime());
        format = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        date = format.parse("19700101 00:00:00");
        System.out.println(date.getTime());
        System.out.println(new Date(0L));
        List<String> ids = new ArrayList<>();
        ids.add(null);
        ids.add(null);
        ids.add("1");
        ids.add(null);
        ids.add(null);
        Iterator<String> iterator = ids.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == null) {
                iterator.remove();
            }
        }
        System.out.println(ids);
        Multimap<String, Object> map = ArrayListMultimap.create();
        map.put("1", 2);
        map.put("1", 2);
        map.put("1", 3);
        System.out.println(map.get("1"));


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

class IntegerCalUtils {
    Integer sum(Integer a, Integer b) {
        return Optional.ofNullable(a).orElse(0) + Optional.ofNullable(b).orElse(b);
    }

    public static BigDecimal add(BigDecimal a, BigDecimal b) {
        return (a == null ? BigDecimal.ZERO : a).add(b);
    }

    public static BigDecimal addNew(BigDecimal a, BigDecimal b) {
        return Optional.ofNullable(a).orElse(BigDecimal.ZERO).add(Optional.ofNullable(b).orElse(BigDecimal.ZERO));
    }
}
