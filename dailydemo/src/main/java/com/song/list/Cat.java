package com.song.list;





import com.google.common.collect.Lists;

import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author songchengxiang
 * @Classname Animal
 * @Description TODO
 * @Date 2019/4/16 18:54
 */
public class Cat extends Animal {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();

        Animal animal = new Cat();
        animal.setAge(1);
        animal.getAge();
        System.out.println(animal);
    }

    private Integer age;

    @Override
    public Integer getAge() {
        System.out.println("c:getAge");
        return age;
    }

    @Override
    public void setAge(Integer age) {
        super.setAge(age);
        System.out.println("c:setAge");
        this.age = age;
    }
}

class Animal {
    private Integer age;

    public Integer getAge() {
        System.out.println("a:getAge");
        return age;
    }

    public void setAge(Integer age) {
        System.out.println("a:setAge");
        this.age = age;
    }
}