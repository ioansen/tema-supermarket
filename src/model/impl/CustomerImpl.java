package model.impl;

import model.*;
import observe.Notification;
import strategy.Strategy;

import java.util.ArrayList;
import java.util.List;

public class CustomerImpl implements Customer {

    private final String name;
    private final ShoppingCart shoppingCart;
    private final WishList wishList;
    private final List<Notification> notifications;

    public CustomerImpl(String name, double budget, Strategy strategy) {
        this.name = name;
        notifications = new ArrayList<>();
        shoppingCart = new ShoppingCart(budget);
        wishList = new WishList(strategy);
    }

    public String getName() {
        return name;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public WishList getWishList() {
        return wishList;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }


    @Override
    public void update(Notification notification) {
        notifications.add(notification);
        switch (notification.getType()){
            case ADD:
                break;
            case MODIFY:
                break;
            case REMOVE:
                break;
        }
    }

    @Override
    public void addToWishList(Item item){
        wishList.add(item);
        item.getDepartment().addObserver(this);
    }

    @Override
    public void addToCart(Item item){
        shoppingCart.add(Item.copy(item));
        //item.getDepartment().addObserver(this);
    }

    @Override
    public void removeFromWishList(Item item){
        wishList.remove(item);
        Department department = item.getDepartment();
        boolean doNotRemove = false;
        for ( Item i : wishList){
            if (department.getId() == i.getDepartment().getId()){
                doNotRemove = true;
                break;
            }
        }

        if(!doNotRemove) department.removeObserver(this);
    }

    @Override
    public void removeFromCart(Item item){
        shoppingCart.remove(item);
    }

    @Override
    public String toString() {
        return name;
    }
}
