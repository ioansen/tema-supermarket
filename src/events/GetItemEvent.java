package events;

import model.*;

public class GetItemEvent implements Event {

    private final String customerName;

    public GetItemEvent(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void fire() {
        Store store = Store.getInstance();
        Customer customer = store.getCustomer(customerName);
        WishList wishList = customer.getWishList();
        Item selectedItem = wishList.executeStrategy();
        customer.removeFromWishList(selectedItem);
        customer.addToCart(selectedItem);
        System.out.println(selectedItem);
    }
}
