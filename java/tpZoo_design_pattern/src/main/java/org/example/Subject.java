package org.example;

public interface Subject <T>{
    void registerObserver(Observer<T> oberver);
    void removeObserver(Observer<T> observer);
    void notifyObservers(T element);


}
