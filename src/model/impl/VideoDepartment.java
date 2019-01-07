package model.impl;

import model.AbstractDepartment;
import visit.Visitor;

public class VideoDepartment extends AbstractDepartment {

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
