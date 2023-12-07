package org.example.exoVisitor;

public class Main {
    public static void main(String[] args) {
        Developer developer = new Developer();
        developer.accept(new PerformanceEvaluator());
        developer.accept(new SalaryAdjuster());

        Manager manager = new Manager();
        manager.accept(new PerformanceEvaluator());
        manager.accept(new SalaryAdjuster());
    }

}
