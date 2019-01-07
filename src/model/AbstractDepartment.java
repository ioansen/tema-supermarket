package model;

import observe.Notification;
import observe.Observer;
import visit.Visitor;

import java.util.List;

public abstract class AbstractDepartment implements Department {

    private final long id;
    private List<Customer> customers;
    private List<Item> items;

    private static long nextDepId;

    {
        id = nextDepId++;
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
    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void addItem(Item item) {
        items.add(item);
        item.setDepartment(this);
    }

    @Override
    public List<Item> getItems() {
        return items;
    }

    @Override
    public void addObserver(Observer observer) {

    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyAllObservers(Notification notification) {

    }

    @Override
    public abstract void accept(Visitor v);
}
