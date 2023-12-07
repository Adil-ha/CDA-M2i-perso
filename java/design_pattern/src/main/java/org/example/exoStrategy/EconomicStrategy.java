package org.example.exoStrategy;

public class EconomicStrategy implements NavigationStrategy{
    @Override
    public void navigate(String destination) {
        System.out.println("Economic strategy navigation to" + destination);
    }
}
