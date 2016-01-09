package com.qualcomm.ftcrobotcontroller.opmodes.Testers;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.Timer;

/**
 * Created by Chaitu on 21-11-2015.
 */

// Tests DebrisLift function
public class TesterDebrisLift {
    DcMotor debrisLiftMotor;

    public void testerDebrisLift() {
        // Takes in debris for score
        // Lasts ten seconds
        debrisLiftMotor.setPower(1);
        Timer.sleep(10000);
        // Releases debris
        debrisLiftMotor.setPower(-1);
        Timer.sleep(10000);

    }
    // Constructor for calling upon
    public TesterDebrisLift(DcMotor TDL) {
        debrisLiftMotor = TDL;
    }
}