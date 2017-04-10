package com.example.eladron.androidappdevforbeginners.Model;

/**
 * Created by eladron on 19/02/2017.
 */

public class Computer {

    private int id;
    private String computerName;
    private String computerType;

    //an Empty constructor of our computer class
    public Computer() {

    }

    public Computer(int id, String name, String type) {

        this.id = id;
        this.computerName = name;
        this.computerType = type;
    }

    public Computer(String name, String type) {

        this.computerName = name;
        this.computerType = type;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getComputerType() {
        return computerType;
    }

    public void setComputerType(String computerType) {
        this.computerType = computerType;
    }
}
