package strategy;

import model.Item;
import model.WishList;

public class StrategyA implements Strategy {

    @Override
    public Item execute(WishList wishList) {
        Item min = wishList.getHead();
        for ( Item item : wishList){
            if ( item.getPrice() < min.getPrice())
                min = item;
        }
        return min;
    }
}
