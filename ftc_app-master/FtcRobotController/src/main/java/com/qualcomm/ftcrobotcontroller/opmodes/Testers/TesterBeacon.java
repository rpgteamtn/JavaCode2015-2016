package com.qualcomm.ftcrobotcontroller.opmodes.Testers;

import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.BeaconDriver;
import com.qualcomm.robotcore.hardware.DcMotor;

public class TesterBeacon {
    BeaconDriver beaconDriver;

    public void testBeacon() {
        beaconDriver.beaconPusher();
    }

    public TesterBeacon(){}
}