package com.example.eladron.app18;

/**
 * Created by eladron on 31/12/2016.
 */

public class CompanyAndDevice {


    private final String COMPANY_NAME;
    private final String COMPANY_DEVICE;


    public CompanyAndDevice(String compName, String compDevice) {

        this.COMPANY_NAME = compName;
        this.COMPANY_DEVICE = compDevice;
    }

    @Override
    public String toString() {

        return " " + COMPANY_DEVICE + " From " + COMPANY_NAME + " Company " + ".\n\n\n";
    }

}
