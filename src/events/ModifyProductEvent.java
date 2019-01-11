package events;

import model.Department;
import model.Item;
import model.Store;
import repositories.ItemRepository;

public class ModifyProductEvent implements Event{

    private final int depId;
    private final int itemId;
    private final double price;

    public ModifyProductEvent(int depId, int itemId, double price) {
        this.depId = depId;
        this.itemId = itemId;
        this.price = price;
    }

    @Override
    public void fire() {
        Store store = Store.getInstance();
        Department department = store.getDepartment(depId);
        Item item = department.getItem(itemId);
        item.setPrice(price);
        department.modifyItem(item);
        ItemRepository.getRepo().save(item);
    }
}
