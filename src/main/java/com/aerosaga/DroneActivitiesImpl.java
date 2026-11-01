package com.aerosaga;

public class DroneActivitiesImpl implements DroneActivities {

    @Override
    public void takeoff() {
        System.out.println("Drone is taking off...");
        System.out.println("Takeoff successful!");
    }

    @Override
    public void navigateToDestination() {
        System.out.println("Drone is navigating to the destination...");
        System.out.println("Destination reached successfully!");
    }

    @Override
    public void deliverPackage() {
        System.out.println("Drone is attempting package delivery...");
        throw new
        RuntimeException("Package delivered failed!");
    }

    @Override
     public void returnToBase() {
    System.out.println("Package delivery failed!");
    System.out.println("Drone is returning to base...");
    System.out.println("Drone successfully returned to base!");
}
}