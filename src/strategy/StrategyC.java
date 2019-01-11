package strategy;

import model.Item;
import model.WishList;

public class StrategyC implements Strategy {

    @Override
    public Item execute(WishList wishList) {

        return wishList.getLastAdded();
    }
}
