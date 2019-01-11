package model;

import model.impl.BookDepartment;
import model.impl.MusicDepartment;
import model.impl.SoftwareDepartment;
import model.impl.VideoDepartment;
import visit.Visitor;

import java.util.Comparator;

public class ShoppingCart extends ItemList implements Visitor {

    private double budget;

    private class ItemComparator implements Comparator<Item> {
        @Override
        public int compare(Item o1, Item o2) {
            int price = Double.compare(o1.getPrice(), o2.getPrice());
            return price != 0 ? price : o1.getName().compareTo(o2.getName());
        }
    }


    public ShoppingCart(double budget) {
        this.budget = budget;
    }

    public void add(Item item) {
        if ( budget - item.getPrice() > 0) {
            super.add(item);
            budget -= item.getPrice();
        }
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    private void updatePrice(Item item, double proc){
        budget += item.getPrice(); //add full price
        item.setPrice(item.getPrice() * proc);
        budget -= item.getPrice(); //subtract reduced price

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

            }
        }
        if ( totalValue > videoDepartment.getTheMostExpensive().getPrice()){
            for ( Item item : this){
                if ( item.getDepartment().equals(videoDepartment)){
                    updatePrice(item, 0.85);
                }
            }
        }
        budget += totalValue / 5;
    }

    @Override
    public void visit(SoftwareDepartment softwareDepartment) {
        if (  budget < softwareDepartment.getCheapestItem().getPrice()) {
            for (Item item : this) {
                if (item.getDepartment().equals(softwareDepartment)) {
                    updatePrice(item, 0.8);
                }
            }
        }
    }
}
