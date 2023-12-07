package org.example.exoObservable;
import java.util.ArrayList;
import java.util.List;
public class Product implements Subject {
    private int stockLevel;
    private List<Observer> observers;

    public Product(){
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setStockLevel(int newStockLevel) {
        if (this.stockLevel != newStockLevel) {
            this.stockLevel = newStockLevel;
            notifyObservers();
        }
    }

    @Override
    public void notifyObservers() {
        observers.forEach(o ->o.update(stockLevel));
    }
}