package org.example.exoVisitor;

public class PerformanceEvaluator implements EmployeeVisitor{
    @Override
    public void visit(Developer developer) {
        System.out.println("Performance evaluate for " +developer );
    }

    @Override
    public void visit(Designer designer) {
        System.out.println("Performance evaluate for " +designer );
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("Performance evaluate for " +manager );
    }
}
