package org.example.exoVisitor;

public class SalaryAdjuster implements EmployeeVisitor{
    @Override
    public void visit(Developer developer) {
        System.out.println("Salary adjuster for "+developer);
    }

    @Override
    public void visit(Designer designer) {
        System.out.println("Salary adjuster for "+designer);
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("Salary adjuster for "+manager);
    }
}
