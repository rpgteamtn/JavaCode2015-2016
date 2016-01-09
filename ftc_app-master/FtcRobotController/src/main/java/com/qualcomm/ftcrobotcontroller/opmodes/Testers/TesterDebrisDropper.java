package com.qualcomm.ftcrobotcontroller.opmodes.Testers;

import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.Timer;
import com.qualcomm.robotcore.hardware.DcMotor;

public class TesterDebrisDropper
{
    // Connects DebrisDrop to DcMotor function
    DcMotor DebrisDropperMotor;

    public void DebrisDropperTester()
    {
        // Motors drop debris
        // Drops for 5 seconds then stops
        DebrisDropperMotor.setPower(1);
        Timer.sleep(5000);
        DebrisDropperMotor.setPower(-1);
        Timer.sleep(5000);
    }
    // Allows RunTester to call upon program
    public TesterDebrisDropper(){}
}