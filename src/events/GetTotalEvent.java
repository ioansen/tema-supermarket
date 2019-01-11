package events;

import model.Customer;
import model.Store;

public class GetTotalEvent implements Event {

    private final String whichList;
    private final String customerName;

    public GetTotalEvent(String whichValue, String customerName) {
        this.whichList = whichValue;
        this.customerName = customerName;
    }

    @Override
    public void fire() {
        Store store = Store.getInstance();
        Customer customer = store.getCustomer(customerName);
        if (Event.figureOutItemList(whichList)){
            System.out.println(customer.getShoppingCart().getTotalPrice());
        } else {
            System.out.println(customer.getWishList().getTotalPrice());
        }
    }
}
