package org.example.exoVisitor;

public class Manager implements PartElement{
    @Override
    public void accept(EmployeeVisitor visitor) {
        visitor.visit(this);
    }
}
