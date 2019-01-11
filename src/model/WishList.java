package model;

import strategy.Strategy;

public class WishList extends ItemList {

    private Strategy strategy;

    public WishList(Strategy strategy) {
        this.strategy = strategy;
    }

    public Item executeStrategy(){
        Item selectedItem = strategy.execute(this);
        remove(selectedItem);
        return selectedItem;
    }
}
