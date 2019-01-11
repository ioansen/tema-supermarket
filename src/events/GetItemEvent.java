package events;

import model.Customer;
import model.Store;

public class GetItemEvent implements Event {

    private final String customerName;

    public GetItemEvent(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void fire() {
        Store store = Store.getInstance();
        Customer customer = store.getCustomer(customerName);
    }
}
