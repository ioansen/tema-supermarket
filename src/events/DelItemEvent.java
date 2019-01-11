package events;

import model.*;
import model.impl.ItemImpl;

public class DelItemEvent implements Event {

    private final int itemId;
    private final String list;
    private final String customerName;

    public DelItemEvent(int itemId, String list, String customerName) {
        this.itemId = itemId;
        this.list = list;
        this.customerName = customerName;
    }

    @Override
    public void fire() {
        Store store = Store.getInstance();
        Item item = null;
        for ( Department department : store.getDepartments()){
            item = department.getItem(itemId);
            if ( item != null) break;
        }
        Customer customer = store.getCustomer(customerName);
        if ( Event.figureOutItemList(list)) {
            customer.removeFromCart(item);

        } else {
            customer.removeFromWishList(item);
        }
    }
}
