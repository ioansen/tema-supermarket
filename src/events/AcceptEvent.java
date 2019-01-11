package events;

import model.Department;
import model.Store;

public class AcceptEvent implements Event {

    private final int depId;
    private final String customerName;

    public AcceptEvent(int depId, String customerName) {
        this.depId = depId;
        this.customerName = customerName;
    }

    @Override
    public void fire() {
        Store store = Store.getInstance();
        Department department = store.getDepartment(depId);
        department.accept(store.getCustomer(customerName).getShoppingCart());
    }
}
