package model;

import observe.Notification;
import observe.NotificationType;
import observe.Observer;
import visit.Visitor;

import java.util.*;

public abstract class AbstractDepartment implements Department {

    private final int id;
    private Set<Customer> customers;
    private Set<Item> items;
    private Set<Observer> observers;


    public AbstractDepartment(int id) {
        this.id = id;
        customers = new HashSet<>();
        items = new HashSet<>();
        observers = new HashSet<>();
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
        notifyAllObservers(Notification.spawn(id, item.getId(), NotificationType.ADD));
    }

    @Override
    public void removeItem(Item item) {
        items.remove(item);
        item.setDepartment(null);
        notifyAllObservers(Notification.spawn(id, item.getId(), NotificationType.REMOVE));

    }

    @Override
    public void modifyItem(Item item) {
        items.remove(item);
        items.add(item);
        notifyAllObservers(Notification.spawn(id, item.getId(), NotificationType.MODIFY));
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

    @Override
    public Item getItem(int itemId) {
        for ( Item item : items){
            if (itemId == item.getId()){
                return item;
            }
        }
        return null;
    }

    public Set<Observer> getObservers() {
        return observers;
    }
}
