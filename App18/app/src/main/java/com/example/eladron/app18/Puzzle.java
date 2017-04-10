package com.example.eladron.app18;

import java.security.SecureRandom;

/**
 * Created by eladron on 31/12/2016.
 */

public class Puzzle {

    private CompanyAndDevice[] compDeviceArr;
    private int currentDeviceModel;
    private static final int NUMBER_OF_MODELS = 60;
    private static final SecureRandom secureRandomNumbers = new SecureRandom();


    public Puzzle() {

        String[] comapnies = { "Apple", "Google", "Sony", "Samsung", "HTC"};
        String[] devices   = { "Xperia Z3", "iPhone 6", "Galaxy Note8", "Galaxy Note10", "iPod Touch", "HTC M9", "Xperia Z5", "iPod Nano",
                                "Xperia M", "Galaxy S6", "Nexus5", "Nexus10" };

        compDeviceArr = new CompanyAndDevice[NUMBER_OF_MODELS];
        currentDeviceModel = 0;

        for (int index = 0; index < compDeviceArr.length; index++) {
            compDeviceArr[index] = new CompanyAndDevice(comapnies[index/12], devices[index%12]);
        }
    }

    public void letsShuffleTheDevices() {

        currentDeviceModel = 0;

        for (int firstDevice = 0; firstDevice < compDeviceArr.length; firstDevice++) {

            int secodDevice = secureRandomNumbers.nextInt(NUMBER_OF_MODELS);
            CompanyAndDevice tempCompanyDevice = compDeviceArr[firstDevice];
            compDeviceArr[firstDevice] = compDeviceArr[secodDevice];
            compDeviceArr[secodDevice] = tempCompanyDevice;
        }
    }

    public CompanyAndDevice giveMeTheModels() {

        if (currentDeviceModel < compDeviceArr.length)
            return compDeviceArr[currentDeviceModel++];
        else
            return null;
    }


}
