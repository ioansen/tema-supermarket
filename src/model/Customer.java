package model;

import observe.Notification;
import observe.Observer;

import java.util.List;

public interface Customer extends Observer {

    String getName();


    ShoppingCart getShoppingCart();


    WishList getWishList();


    List<Notification> getNotifications();


    void addToWishList(Item item);


    void addToCart(Item item);

    void removeFromWishList(Item item);

    void removeFromCart(Item item);
}
