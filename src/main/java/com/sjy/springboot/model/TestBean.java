package com.sjy.springboot.model;

/**
 * @author sjy on 2018/12/2
 * @version 1.0
 */
public class TestBean {
    private int id;
    private String name;

    public TestBean() {

    }
//构造函数初始化传值
    public TestBean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}