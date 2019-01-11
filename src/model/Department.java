package model;

import observe.Subject;
import visit.Visitable;

import java.util.List;
import java.util.Set;

public interface Department extends Subject, Visitable, WithId {

    /**
     * A customer bought at lest one product from this department???
     * What's that supposed to mean
     * What is this method doing?
     */
    void enter(Customer customer);

    /**
     * The customer decided that he doesn't want to buy from this department ever again
     */
    void exit(Customer customer);

    /**
     * Returns all the customers that bought at least one product from this department
     *
     * @return the list of customers
     */
    List<Customer> getCustomers();

    /**
     *Adds a new item (aka product) to this department
     *
     * @param item the item to add
     */
    void addItem(Item item);

    void removeItem(Item item);

    void modifyItem(Item item);
    /**
     * Returns the list of items (products) currently available in this department
     *
     * @return the list of items
     */
    List<Item> getItems();


    Item getItem(int itemId);

}
