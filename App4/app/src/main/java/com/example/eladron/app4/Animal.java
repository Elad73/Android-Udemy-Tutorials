package com.example.eladron.app4;

/**
 * Created by eladron on 21/12/2016.
 */

public class Animal extends Object {

    private final String _name;
    private final String _color;
    private int _amountOfSpeed;
    private int _amountOfPower;


    //Constructors
    public Animal ()
    {
        _name = "Animal";
        _color = "Black";
        _amountOfPower = 0;
        _amountOfSpeed = 0;
    }

    public Animal (String name, String color, int amountOfSpeed, int amountOfPower)
    {
        _name = name;
        _color = color;
        _amountOfPower = amountOfPower;
        _amountOfSpeed = amountOfSpeed;
    }

    //Getters
    public String getName()       {   return _name;}
    public String getColor()        {   return _color;}
    public int getAmountOfSpeed() {   return _amountOfSpeed;}
    public int getAmountOfPower() {   return _amountOfPower;}

    //Setters
    public void setAmountOfSpeed(int value) {   _amountOfSpeed = value;}
    public void setAmountOfPower(int value) {   _amountOfPower = value;}

    @Override
    public String toString() { return  String.format("Name: %s Color: %s %d %d", _name, _color, _amountOfSpeed, _amountOfPower);}

}
