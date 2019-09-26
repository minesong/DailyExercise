package com.song.testng.test;


import org.apache.commons.lang3.tuple.MutableTriple;
import org.testng.annotations.Test;

import java.time.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListStreamTest {
    void test1(List list){
        list = new ArrayList();
        System.out.println(list);
    }
    @Test
    public void test() {
        List list =null;
        test1(list);
        MutableTriple<String,Integer,String> triple =new MutableTriple<>();
        B b1 = new B(4L);
        B b11 = new B(2L);
        A a1 = new A();
        A a2 = new A();
        a1.getbList().add(b1);
        a1.getbList().add(b11);
        B b2 = new B(7L);
        B b21 = new B(3L);
        B b22 = new B(9L);
        a2.getbList().add(b2);
        a2.getbList().add(b21);
        a2.getbList().add(b22);
        List<A> aList = Arrays.asList(a1, a2);
        List list1 = aList.stream().map(a -> a.getbList().stream().map(B::getId).collect(Collectors.toList())).collect(Collectors.toList());
        System.out.println(list1);
    }

    class A {
        List<B> bList = new ArrayList<>();

        public List<B> getbList() {
            return bList;
        }

        public void setbList(List<B> bList) {
            this.bList = bList;
        }
    }

    class B {
        private Long id;

        public B(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "id:" + id;
        }
    }
}
