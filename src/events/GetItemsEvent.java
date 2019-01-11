package events;

import model.Customer;
import model.Item;
import model.Store;

public class GetItemsEvent implements Event{

    private final String whichList;
    private final String customerName;

    public GetItemsEvent(String whichList, String customerName) {
        this.whichList = whichList;
        this.customerName = customerName;
    }

    @Override
    public void fire() {
        Store store = Store.getInstance();
        Customer customer = store.getCustomer(customerName);

        if ( Event.figureOutItemList(whichList)){
            System.out.println(customer.getShoppingCart());
        } else {
            System.out.println(customer.getWishList());
        }
    }
}
