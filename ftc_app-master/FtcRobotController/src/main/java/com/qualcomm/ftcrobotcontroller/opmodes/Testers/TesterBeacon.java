package com.qualcomm.ftcrobotcontroller.opmodes.Testers;

import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.BeaconDriver;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Josh
 */
public class TesterBeacon {
    BeaconDriver beaconDriver;
    // Will test beacon pusher function
    public void testBeacon() {
        beaconDriver.beaconPusher();
    }
    // Can be called on through constructor
    public TesterBeacon(){}
}