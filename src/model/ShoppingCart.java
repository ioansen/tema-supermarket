package model;

import visit.Visitor;

import java.util.Comparator;

public class ShoppingCart extends ItemList implements Visitor {

    private double budget;
    private double current;

    private class ItemComparator implements Comparator<Item> {
        @Override
        public int compare(Item o1, Item o2) {
            int price = Double.compare(o1.getPrice(), o2.getPrice());
            return price != 0 ? price : o1.getName().compareTo(o2.getName());
        }
    }


    public ShoppingCart(double budget) {
        this.budget = budget;
        current = 0;
        this.sort(new ItemComparator());
    }

    @Override
    public boolean add(Item item) {
        if ( current + item.getPrice() < budget) {
            super.add(item);
            current += item.getPrice();
        }
        return false;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getCurrent() {
        return current;
    }
}
