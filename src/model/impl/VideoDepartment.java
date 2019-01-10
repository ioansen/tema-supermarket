package model.impl;

import model.AbstractDepartment;
import visit.Visitor;

public class VideoDepartment extends AbstractDepartment {

    public VideoDepartment(int id) {
        super(id);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
