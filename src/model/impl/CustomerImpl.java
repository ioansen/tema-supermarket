package model.impl;

import model.Customer;
import model.Item;
import model.ShoppingCart;
import model.WishList;
import observe.Notification;

import java.util.ArrayList;
import java.util.List;

public class CustomerImpl implements Customer {

    private final String name;
    private final ShoppingCart shoppingCart;
    private final WishList wishList;
    private final List<Notification> notifications;

    public CustomerImpl(String name, double budget) {
        this.name = name;
        notifications = new ArrayList<>();
        shoppingCart = new ShoppingCart(budget);
        wishList = new WishList();
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
    }

    public void addToWishList(Item item){
        wishList.add(item);
        item.getDepartment().addObserver(this);
    }

    public void addToCart(Item item){
        shoppingCart.add(Item.copy(item));
        item.getDepartment().addObserver(this);
    }
}
