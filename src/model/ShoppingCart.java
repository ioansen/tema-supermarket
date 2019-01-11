package model;

import model.impl.BookDepartment;
import model.impl.MusicDepartment;
import model.impl.SoftwareDepartment;
import model.impl.VideoDepartment;
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
//        this.sort(new ItemComparator());
    }

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

    private void updatePrice(Item item, double proc){
        current -= item.getPrice();
        item.setPrice(item.getPrice() * proc);
        current += item.getPrice();

    }


    @Override
    public void visit(BookDepartment bookDepartment) {
        for ( Item item : this){
            if ( item.getDepartment().equals(bookDepartment)){
               updatePrice(item, 0.9);
            }
        }
    }

    @Override
    public void visit(MusicDepartment musicDepartment) {
        double totalValue = 0;
        for ( Item item : this){
            if ( item.getDepartment().equals(musicDepartment)){
                totalValue += item.getPrice();
            }
        }
        budget += totalValue / 10;
    }

    @Override
    public void visit(VideoDepartment videoDepartment) {
        double totalValue = 0;
        for ( Item item : this){
            if ( item.getDepartment().equals(videoDepartment)){
                totalValue += item.getPrice();
                updatePrice(item, 0.85);
            }
        }
        budget += totalValue / 5;
    }

    @Override
    public void visit(SoftwareDepartment softwareDepartment) {
        for ( Item item : this){
            if ( item.getDepartment().equals(softwareDepartment)){
                updatePrice(item, 0.8);
            }
        }
    }
}
