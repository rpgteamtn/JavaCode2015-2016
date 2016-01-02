package com.qualcomm.ftcrobotcontroller.opmodes.Testers;

import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.Timer;
import com.qualcomm.robotcore.hardware.DcMotor;

public class TesterDebrisDropper
{
    DcMotor DebrisDropperMotor;

    public void DebrisDropperTester()
    {
        DebrisDropperMotor.setPower(1);
        Timer.sleep(5000);
        DebrisDropperMotor.setPower(-1);
        Timer.sleep(5000);
    }
    public TesterDebrisDropper(){}
}