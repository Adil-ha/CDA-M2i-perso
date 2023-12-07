package org.example.exoVisitor;

public class Developer implements PartElement {
    @Override
    public void accept(EmployeeVisitor visitor) {
        visitor.visit(this);
    }
}
