package strategy;

import model.Item;
import model.WishList;

public interface Strategy {

    Item execute(WishList wishList);
}

