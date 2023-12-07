package org.example.exoObservable;

public class StockManager implements Observer {
    private String name;

    public StockManager(String name) {
        this.name = name;
    }

    @Override
    public void update(int stockLevel) {
        System.out.println("StockManager " + name + " notified. New stock level: " + stockLevel);
    }
}