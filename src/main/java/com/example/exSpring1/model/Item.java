package com.example.exSpring1.model;

public class Item {
    private String name;
    private Integer price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    
}
