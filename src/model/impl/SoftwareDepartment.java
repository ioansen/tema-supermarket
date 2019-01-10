package model.impl;

import model.AbstractDepartment;
import visit.Visitor;

public class SoftwareDepartment extends AbstractDepartment {

    public SoftwareDepartment(int id) {
        super(id);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
