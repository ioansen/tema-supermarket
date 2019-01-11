package model;

import strategy.Strategy;

import java.util.Comparator;

public class WishList extends ItemList {

    private Strategy strategy;
    private Item lastAdded;

    public WishList(Strategy strategy) {
        this.strategy = strategy;
    }

    public Item executeStrategy(){
        Item selectedItem = strategy.execute(this);
        return selectedItem;
    }

    @Override
    public void add(Item item) {
        super.add(item);
        lastAdded = item;
    }

    public Item getLastAdded() {
        return lastAdded;
    }
}
