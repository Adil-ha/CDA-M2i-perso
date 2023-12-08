package org.example;

import java.util.ArrayList;
import java.util.List;

public class Zoo implements Subject<String> {
    private static volatile Zoo instance = null;

    private static final Object lock = new Object();
    private List<Observer<String>> observers;

    private Zoo() {
        observers  = new ArrayList<>();
    }

    public static Zoo getInstance() {
        if (instance == null) {
            synchronized (lock){
                instance = new Zoo();
            }

        }
        return instance;
    }

    @Override
    public void registerObserver(Observer<String> observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer<String> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String event) {
        for (Observer<String> observer : observers) {
            observer.update(event);
        }
    }

    public void simulateEvent(String event) {
        System.out.println("Event: " + event);
        notifyObservers(event);
    }

}
