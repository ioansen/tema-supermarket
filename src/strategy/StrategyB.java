package strategy;

import model.Item;
import model.WishList;

public class StrategyB implements Strategy {

    @Override
    public Item execute(WishList wishList) {
        return wishList.getHead();
    }
}
