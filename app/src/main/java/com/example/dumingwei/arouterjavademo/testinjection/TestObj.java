package com.example.dumingwei.arouterjavademo.testinjection;

public class TestObj {

    public String name;
    public int id;

    /**
     * 无参构造函数必须要
     */
    public TestObj() {
    }

    public TestObj(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "TestObj{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
