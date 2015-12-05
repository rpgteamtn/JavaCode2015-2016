package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.BeaconDriver;

public class TesterBeacon
{
    BeaconDriver beaconDriver;

    public void testBeacon() { BeaconDriver.dropBeacon(); }
}
    public TesterBeacon (DcMotor TB) { testerBeaconMotor = TB; }