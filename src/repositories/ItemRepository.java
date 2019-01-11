package repositories;

import model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository implements Repository<Item>{

    private List<Item> items;
    private static ItemRepository ITEMREPO = null;

    {
        items = new ArrayList<>();
    }

    public static ItemRepository getRepo(){
        if ( null == ITEMREPO){
            ITEMREPO = new ItemRepository();
        }
        return ITEMREPO;
    }


    @Override
    public void save(Item item) {
        if ( find(item.getId()) != null ){
            delete(item);
        }
        items.add(item);
    }

    @Override
    public Item delete(int id) {
        Item item = find(id);
        items.remove(item);
        return item;
    }

    @Override
    public void delete(Item item) {
        items.remove(item);
    }

    @Override
    public Item find(int id) {
        for (Item item : items){
            if ( item.getId() == id){
                return item;
            }
        }
        return null;
    }

    @Override
    public List<Item> findAll() {
        return items;
    }
}
