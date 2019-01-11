package model;

import observe.Notification;
import observe.NotificationType;
import observe.Observer;
import visit.Visitor;

import java.util.*;

public abstract class AbstractDepartment implements Department {

    private final int id;
    private List<Customer> customers;
    private List<Item> items;
    private List<Observer> observers;


    public AbstractDepartment(int id) {
        this.id = id;
        customers = new ArrayList<>();
        items = new ArrayList<>();
        observers = new ArrayList<>();
    }

    @Override
    public void enter(Customer customer) {
        if ( !customers.contains(customer))
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
        notifyAllObservers(Notification.spawn(id, item.getId(), NotificationType.REMOVE));

    }

    @Override
    public void modifyItem(Item item) {
        Item mine = getItem(item.getId());
        mine.setPrice(item.getPrice());
        notifyAllObservers(Notification.spawn(id, item.getId(), NotificationType.MODIFY));
    }

    @Override
    public List<Item> getItems() {
        return items;
    }

    @Override
    public void addObserver(Observer observer) {
        if ( !observers.contains(observer))
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

    public List<Observer> getObservers() {
        return observers;
    }
}
