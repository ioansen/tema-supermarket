package model;

import model.impl.ItemImpl;

/**
 * Represents a unit that can be sold in a department
 */
public interface Item {

    /**
     * @return the id of this item
     */
    long getId();

    /**
     * @return the name of this item
     */
    String getName();

    /**
     * @return the price of this item
     */
    double getPrice();

    /**
     * Sets a new price for this item
     *
     * @param price the new price
     */
    void setPrice(double price);

    /**
     * @return the department this item is currently assigned to
     */
    Department getDepartment();

    /**
     * Set a new department for this item
     *
     * @param department the new department
     */
    void setDepartment(Department department);

    /**
     * Creates a copy of an item
     *
     * @param item the item to copy
     * @return the copy of the item
     */
    static Item copy(Item item){
        return new ItemImpl(item.getName(), item.getPrice(), item.getDepartment());
    }
}
