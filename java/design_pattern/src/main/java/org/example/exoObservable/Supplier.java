package org.example.exoObservable;

class Supplier implements Observer {
    private String name;

    public Supplier(String name) {
        this.name = name;
    }

    @Override
    public void update(int stockLevel) {
        System.out.println("Supplier " + name + " notified. New stock level: " + stockLevel);
    }
}
