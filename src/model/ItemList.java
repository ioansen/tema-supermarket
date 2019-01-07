package model;

import util.LinkedList;

import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;

public abstract class ItemList extends LinkedList<Item> {

    public Double getTotalPrice(){
        Iterator<Item> itr = iterator();
        double price = 0;
        while (itr.hasNext()){
            price += itr.next().getPrice();
        }
        return price;
    }
}
