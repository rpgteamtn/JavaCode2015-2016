package com.qualcomm.ftcrobotcontroller.opmodes.Testers;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.Timer;

/**
 * Created by Chaitu on 21-11-2015.
 */
public class TesterDebrisLift {
    DcMotor debrisLiftMotor;

    public void testerDebrisLift() {
        debrisLiftMotor.setPower(1);
        Timer.sleep(10000);
        debrisLiftMotor.setPower(-1);
        Timer.sleep(10000);

    }

    public TesterDebrisLift(DcMotor TDL) {
        debrisLiftMotor = TDL;
    }
}