package events;

import model.*;
import repositories.ItemRepository;

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
        Item item = ItemRepository.getRepo().find(itemId);
        Customer customer = store.getCustomer(customerName);
        if ( Event.figureOutItemList(list)) {
            customer.removeFromCart(item);
        } else {
            customer.removeFromWishList(item);
        }
    }
}
