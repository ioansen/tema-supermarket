package model.impl;


import model.Department;
import model.Item;

public class ItemImpl implements Item {

    private final long id;
    private final String name;
    private double price;
    private Department department;

    private static int nextItemId = 0;

    {
        id = nextItemId++;
    }

    public ItemImpl(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public ItemImpl(String name, double price, Department department) {
        this.name = name;
        this.price = price;
        this.department = department;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}