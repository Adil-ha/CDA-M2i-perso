package org.example.exoObservable;

public class Main {
    public static void main(String[] args) {

        Product product = new Product();
;
        StockManager stockManager1 = new StockManager("StockManager1");
        StockManager stockManager2 = new StockManager("StockManager2");
        Supplier supplier1 = new Supplier("Supplier1");
        Supplier supplier2 = new Supplier("Supplier2");

        product.addObserver(stockManager1);
        product.addObserver(stockManager2);
        product.addObserver(supplier1);
        product.addObserver(supplier2);

        product.setStockLevel(20);
        product.removeObserver(supplier2);
        product.setStockLevel(15);
    }
}
