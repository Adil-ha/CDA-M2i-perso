package org.example.exoStrategy;

public class OffroadStrategy implements NavigationStrategy{
    @Override
    public void navigate(String destination) {
        System.out.println("Off road strategy navigation to " + destination);
    }
}
