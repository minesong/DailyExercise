package com.song.concurrent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by scx on 2019/7/8.
 */
public class MapMerge implements Serializable {
    private static Map<String, Employee> map1 = new HashMap<>();
    private static Map<String, Employee> map2 = new HashMap<>();
    public static void main(String[] args) {
        //  private Long id;
        // private String name;
        Employee employee1 = new Employee(11L, "Henry");
        map1.put(employee1.getName(), employee1);
        Employee employee2 = new Employee(12L, "Annie");
        map1.put(employee2.getName(), employee2);
        Employee employee3 = new Employee(13L, "John");
        map1.put(employee3.getName(), employee3);

        Employee employee4 = new Employee(21L, "George");
        map2.put(employee4.getName(), employee4);
        Employee employee5 = new Employee(22L, "Henry");
        map2.put(employee5.getName(), employee5);

        Map<String, Employee> map3 = new HashMap<>(map1);
        for (Map.Entry<String, Employee> entry : map2.entrySet()) {
            map3.merge(entry.getKey(), entry.getValue(),
                    (oldValue, value) -> new Employee(oldValue.getId(), value.getName()));
            //map2中的值覆盖到map3中
            if (map3.containsKey(entry.getKey())) {
                map3.put(entry.getKey(), new Employee(map3.get(entry.getKey()).getId(),
                        entry.getValue().getName()));
            } else {
                map3.put(entry.getKey(),entry.getValue());
            }
        }
        System.out.println(map3);
    }

}

class Employee {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}