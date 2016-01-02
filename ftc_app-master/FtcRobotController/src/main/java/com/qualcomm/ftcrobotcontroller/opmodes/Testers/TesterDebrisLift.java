package com.qualcomm.ftcrobotcontroller.opmodes.Testers;

import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.DebrisLiftDriver;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.Timer;

/**
 * Created by Chaitu on 21-11-2015.
 */
public class TesterDebrisLift {
    DebrisLiftDriver DebrisLiftDriver;
    DcMotor debrisLiftMotor;

    public void testerDebrisLift() {
        DebrisLiftDriver.debrisLiftMotor.setPower(1);
        Timer.sleep(10000);
        DebrisLiftDriver.debrisLiftMotor.setPower(-1);
        Timer.sleep(10000);

    }

    public TesterDebrisLift(DcMotor TDL) {
        debrisLiftMotor = TDL;
    }
}