package model.impl;


import model.Department;
import model.Item;

import java.util.Objects;

public class ItemImpl implements Item {

    private final int id;
    private final String name;
    private double price;
    private Department department;


    public ItemImpl(String name, int id, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public ItemImpl(String name, int id, double price, Department department) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.department = department;
    }

    @Override
    public int getId() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemImpl item = (ItemImpl) o;
        return Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
