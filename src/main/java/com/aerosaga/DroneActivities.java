package com.aerosaga;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface DroneActivities {

    @ActivityMethod
    void takeoff();

    @ActivityMethod
    void navigateToDestination();

    @ActivityMethod
    void deliverPackage();

    @ActivityMethod
    void returnToBase();
}
