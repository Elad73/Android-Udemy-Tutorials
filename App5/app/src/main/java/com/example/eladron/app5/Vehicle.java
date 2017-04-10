package com.example.eladron.app5;

/**
 * Created by eladron on 22/12/2016.
 */

public class Vehicle extends Object{

    private int speed;
    private final boolean hasBreakingSystem;
    private int numberOfWheels;

    private int rideSpeed;

    //Constructors
    public Vehicle(int speed, boolean hasBreakingSystem, int numberOfWheels)
    {
        this.speed = speed;
        this.hasBreakingSystem = hasBreakingSystem;
        this. numberOfWheels = numberOfWheels;

    }

    //Getters & Setters
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isHasBreakingSystem() {
        return hasBreakingSystem;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public int getRideSpeed() {
        return rideSpeed;
    }

    //Methods
    public void ride() {

        int result = getSpeed() * getNumberOfWheels();
        rideSpeed = result;
    }

    @Override
    public String toString() {
        return "Speed: " + getSpeed() + ", Has breaks: " + isHasBreakingSystem() + ", Wheels number: " +
                getNumberOfWheels() + ", Ride speed: " + getRideSpeed();
    }
}
