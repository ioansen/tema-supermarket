package model.impl;

import model.AbstractDepartment;
import model.Item;
import visit.Visitor;

public class VideoDepartment extends AbstractDepartment {

    public VideoDepartment(int id) {
        super(id);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    public Item getTheMostExpensive(){
        Item max = getItems().iterator().next();
        for (Item item : getItems()){
            if ( item.getPrice() > max.getPrice())
                max = item;
        }
        return max;
    }
}
