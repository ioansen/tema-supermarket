package model;

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
}
