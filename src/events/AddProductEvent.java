package events;

import model.Department;
import model.Item;
import model.Store;
import model.impl.ItemImpl;

public class AddProductEvent implements Event {

    private final int depId;
    private final int itemId;
    private final double price;
    private final String name;

    public AddProductEvent(int depId, int itemId, double price, String name) {
        this.depId = depId;
        this.itemId = itemId;
        this.price = price;
        this.name = name;
    }

    @Override
    public void fire() {
        Store store = Store.getInstance();
        Department department = store.getDepartment(depId);
        Item item = new ItemImpl(name, itemId, price);
        department.addItem(item);
    }
}
