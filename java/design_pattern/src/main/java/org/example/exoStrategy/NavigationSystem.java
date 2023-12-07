package org.example.exoStrategy;


public class NavigationSystem {

    private NavigationStrategy navigationStrategy;

    public NavigationSystem(NavigationStrategy navigationStrategy) {
        this.navigationStrategy = navigationStrategy;
    }

    public void navigate(String destination) {
        if (navigationStrategy != null) {
            navigationStrategy.navigate(destination);
        } else {
            System.out.println("No navigation strategy set.");
        }
    }

    public void setNavigationStrategy(NavigationStrategy navigationStrategy) {
        this.navigationStrategy = navigationStrategy;
    }
}
