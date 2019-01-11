package events;

import model.Store;

public class GetNotificationsEvent implements Event {

    private final String customerName;

    public GetNotificationsEvent(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void fire() {
        System.out.println(Store.getInstance().getCustomer(customerName).getNotifications());
    }
}
