package events;

import model.Department;
import model.Item;
import model.Store;
import repositories.ItemRepository;

public class DelProductEvent implements Event {

    private final int itemId;

    public DelProductEvent(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public void fire() {
        Store store = Store.getInstance();
        Item item = ItemRepository.getRepo().find(itemId);
        for (Department department : store.getDepartments()){
            department.removeItem(item);
            ItemRepository.getRepo().delete(item);
        }
    }
}
