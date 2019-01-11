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
        Department department = selectedItem.getDepartment();
        boolean doNotRemove = false;
        for ( Item item : wishList){
            if (item.getDepartment().getId() == department.getId()){
                doNotRemove = true;
                break;
            }
        }

        if(!doNotRemove) department.removeObserver(customer);
        customer.addToCart(selectedItem);
        System.out.println(selectedItem);
    }
}
