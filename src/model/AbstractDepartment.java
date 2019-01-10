package model;

import observe.Notification;
import observe.Observer;
import visit.Visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public abstract class AbstractDepartment implements Department {

    private final int id;
    private Set<Customer> customers;
    private Set<Item> items;
    private Set<Observer> observers;


    public AbstractDepartment(int id) {
        this.id = id;
        customers = new TreeSet<>();
        items = new TreeSet<>();
        observers = new TreeSet<>();
    }

    @Override
    public void enter(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void exit(Customer customer) {
        customers.remove(customer);
    }

    @Override
    public Set<Customer> getCustomers() {
        return customers;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void addItem(Item item) {
        items.add(item);
        item.setDepartment(this);
    }

    @Override
    public Set<Item> getItems() {
        return items;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllObservers(Notification notification) {
        for(Observer observer : observers){
            observer.update(notification);
        }
    }

    @Override
    public abstract void accept(Visitor v);
}
