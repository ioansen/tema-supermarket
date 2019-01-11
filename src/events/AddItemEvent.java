package events;

import events.Event;
import model.*;
import repositories.ItemRepository;

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
        Item item = ItemRepository.getRepo().find(itemId);
        Customer customer = store.getCustomer(customerName);
        if ( Event.figureOutItemList(list)) {
            customer.addToCart(item);
        } else {
            customer.addToWishList(item);
        }
    }
}
