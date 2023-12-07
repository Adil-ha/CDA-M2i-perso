package org.example.exoStrategy;


public class Main {

    public static void main(String[] args) {
        NavigationSystem navigationSystem = new NavigationSystem(new RoadStrategy());
        navigationSystem.navigate("Tourcoing");
        navigationSystem.setNavigationStrategy(new OffroadStrategy());
        navigationSystem.navigate("Tourcoing");
        navigationSystem.setNavigationStrategy(new EconomicStrategy());
        navigationSystem.navigate("Tourcoing");

    }
}