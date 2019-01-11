package model.impl;

import model.AbstractDepartment;
import model.Item;
import visit.Visitor;

public class SoftwareDepartment extends AbstractDepartment {

    public SoftwareDepartment(int id) {
        super(id);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }


    public Item getCheapestItem(){
        Item min = getItems().iterator().next();
        for (Item item : getItems()){
            if ( item.getPrice() < min.getPrice())
                min = item;
        }
        return min;
    }
}
