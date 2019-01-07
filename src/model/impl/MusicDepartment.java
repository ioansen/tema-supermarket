package model.impl;

import model.AbstractDepartment;
import model.Department;
import visit.Visitor;

public class MusicDepartment extends AbstractDepartment {

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
