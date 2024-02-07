package com.example.exSpring1.model;

public class Member {
    
    private Integer id;
    private String name;
    private String age;
    private Integer depId;

    public Integer getId() {
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
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public Integer getDepId() {
        return depId;
    }
    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
