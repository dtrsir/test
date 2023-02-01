package com.zhong.dao;

public class UserT {
    private String name;

    public UserT() {
        System.out.println("userT被创建了");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
