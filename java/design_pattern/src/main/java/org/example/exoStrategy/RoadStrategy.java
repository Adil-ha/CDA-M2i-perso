package org.example.exoStrategy;

public class RoadStrategy implements NavigationStrategy{
    @Override
    public void navigate(String destination) {
        System.out.println("Road strategy navigation to " + destination);
    }
}
