package com.company;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return this.name;
    }

    public Integer getAge(){
        return this.age;
    }
}