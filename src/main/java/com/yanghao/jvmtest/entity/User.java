package com.yanghao.jvmtest.entity;

/**
 * @program: jvmtest
 * @description:
 * @author: yanghao
 * @create: 2019-03-15 10:55
 **/
public class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
