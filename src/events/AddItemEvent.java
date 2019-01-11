package events;

import model.*;

public class AddItemEvent implements Event {

    private final int itemId;
    private String list;
    private final String customerName;

    public AddItemEvent(int itemId, String list, String customerName) {
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
            customer.addToCart(item);
        } else {
            customer.addToWishList(item);
        }
    }
}
