package model.impl;

import model.AbstractDepartment;
import model.Department;
import visit.Visitor;

public class BookDepartment extends AbstractDepartment {

    public BookDepartment(int id) {
        super(id);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
