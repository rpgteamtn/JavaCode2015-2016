package com.qualcomm.ftcrobotcontroller.opmodes.Testers;

import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.DebrisDropper;

public class TesterDebrisDropper
{
    DebrisDropper DebrisDropper;

    public void DebrisDropperTester()
    {
        DebrisDropper.DebrisDropperMotor.setPower(1);
        sleep(5000);
        DebrisDropper.DebrisDropperMotor.setPower(-1);
        sleep(5000);
    }
    public TesterDebrisDropper(DcMotor TDD) { DebrisDropperMotor = TDD; }
}