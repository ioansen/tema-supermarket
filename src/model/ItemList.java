package model;

import util.LinkedList;

import java.util.ListIterator;

public abstract class ItemList extends LinkedList<Item> {

    public abstract Double getTotalPrice();
}
