package org.example.exoVisitor;

public class Designer implements PartElement{
    @Override
    public void accept(EmployeeVisitor visitor) {
        visitor.visit(this);
    }
}
